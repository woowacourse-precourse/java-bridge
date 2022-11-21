package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
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
        outputView.printGameStartMessage();
        outputView.printBridgeLengthInputMessage();
        int bridgeSize = inputView.readBridgeSize();
        System.out.println();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize));
        crossBridge(bridgeGame);
    }

    private void crossBridge(BridgeGame bridgeGame) {
        boolean movingSuccess;
        boolean allPass = false;
        do {
            outputView.printMoveInputMessage();
            String moving = inputView.readMoving();
            movingSuccess = bridgeGame.move(moving);
            outputView.printMap(bridgeGame.getMovingMap());
            if (!movingSuccess) {
                outputView.printRetryMessage();
                if (inputView.readGameCommand().equals("R")) {
                    bridgeGame.retry();
                    continue;
                }
                else {
                    break;
                }
            }
            allPass = bridgeGame.allPass();
        } while (!allPass);
    }
}
