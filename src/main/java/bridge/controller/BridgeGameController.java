package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.data.Command;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        outputView.printStartMessage();
        int bridgeSize = inputView.readBridgeSize();
        outputView.nextLine();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize));
        crossBridge(bridgeGame);
        outputView.printResult(bridgeGame.getMovingMap(), bridgeGame.allPass(), bridgeGame.getTryCount());
    }

    private void crossBridge(BridgeGame bridgeGame) {
        boolean keepGoing;
        do {
            keepGoing = moveAndCheckMovingSuccess(bridgeGame);
            outputView.printMap(bridgeGame.getMovingMap());
            if (!keepGoing && retryGame(bridgeGame)) {
                keepGoing = true;
            }
        } while (keepGoing && !bridgeGame.allPass());
    }

    private boolean moveAndCheckMovingSuccess(BridgeGame bridgeGame) {
        outputView.printMoveInputMessage();
        String moving = inputView.readMoving();
        return bridgeGame.move(moving);
    }

    private boolean retryGame(BridgeGame bridgeGame) {
        outputView.printRetryMessage();
        if (inputView.readGameCommand().equals(Command.RETRY.getLabel())) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }
}
