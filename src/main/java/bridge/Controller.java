package bridge;

import static bridge.GameCommand.RETRY;

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
        outputView.printBridgeGameStart();
        BridgeGame bridgeGame = createBridgeGame(readBridgeSize());

        do {
            moveToEndOfBridge(bridgeGame);
        } while (!bridgeGame.isWin() && doRetryOrNot(readGameCommand(), bridgeGame));

        outputView.printResult(bridgeGame);
    }

    private int readBridgeSize() {
        return inputView.readBridgeSize(outputView::printBridgeSizeInput);
    }

    private BridgeGame createBridgeGame(int bridgeSize) {
        return new BridgeGame(
                new Bridge(this.bridgeMaker.makeBridge(bridgeSize))
        );
    }

    private GameCommand readGameCommand() {
        return inputView.readGameCommand(outputView::printGameCommandInput);
    }

    private void moveToEndOfBridge(BridgeGame bridgeGame) {
        boolean moveResult = true;
        while (!bridgeGame.isWin() && moveResult) {
            String moveDirection = inputView.readMoving(outputView::printBridgeMoveDirectionInput);
            moveResult = bridgeGame.move(moveDirection);
            outputView.printMap(bridgeGame.getMoveHistory());
        }
    }

    private boolean doRetryOrNot(GameCommand gameCommand, BridgeGame bridgeGame) {
        if (RETRY.equals(gameCommand)) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }
}
