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
            boolean moveState = bridgeGame.move(inputController.readMoving());
            if (moveState) break;
        }while (true);
    }
}
