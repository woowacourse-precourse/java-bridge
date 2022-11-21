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
        boolean allPass;
        do {
            outputView.printMoveInputMessage();
            String moving = inputView.readMoving();
            movingSuccess = bridgeGame.move(moving);
            outputView.printMap(bridgeGame.getMovingMap());
            allPass = bridgeGame.allPass();
        } while (movingSuccess && !allPass);
    }
}
