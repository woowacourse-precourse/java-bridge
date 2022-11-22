package bridge.controller;

import static bridge.core.GameCommand.RETRY;

import bridge.core.Bridge;
import bridge.core.BridgeGame;
import bridge.BridgeMaker;
import bridge.core.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public Controller(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void start() {
        this.outputView.printBridgeGameStart();
        final BridgeGame bridgeGame = createBridgeGame(readBridgeSize());

        do {
            moveToEndOfBridge(bridgeGame);
        } while (!bridgeGame.isWin() && doRetryOrNot(readGameCommand(), bridgeGame));

        this.outputView.printResult(bridgeGame);
    }

    private BridgeGame createBridgeGame(int bridgeSize) {
        return new BridgeGame(
                new Bridge(this.bridgeMaker.makeBridge(bridgeSize))
        );
    }

    private void moveToEndOfBridge(BridgeGame bridgeGame) {
        boolean moveResult = true;
        while (!bridgeGame.isWin() && moveResult) {
            moveResult = bridgeGame.move(readMoving());
            this.outputView.printMap(bridgeGame.getMoveHistory());
        }
    }

    private boolean doRetryOrNot(GameCommand gameCommand, BridgeGame bridgeGame) {
        if (RETRY.equals(gameCommand)) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    private int readBridgeSize() {
        return this.inputView.readBridgeSize(this.outputView::printBridgeSizeInput);
    }

    private GameCommand readGameCommand() {
        return this.inputView.readGameCommand(this.outputView::printGameCommandInput);
    }

    private String readMoving() {
        return this.inputView.readMoving(this.outputView::printBridgeMoveDirectionInput);
    }
}
