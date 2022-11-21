package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.OutputView;

public class GameContoller {
    private final InputController inputController = new InputController();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        outputView.printStart();
        bridgeGame.initBridge(inputController.readBridgeSize());
        do {
            String moving = inputController.readMoving();
            if (bridgeGame.move(moving)) break;
        }while (bridgeGame.retry(inputController.readGameCommand()));
    }
}
