package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.InputView;

public class BridgeGameController {

    private BridgeGame bridgeGame;

    public void start() {
        insertBridge();
    }

    public void insertBridge() {
        String length = InputView.readBridgeSize();
        bridgeGame.createBridge(length);
    }

    public void insertBridgeToMove() {
        String length = InputView.readMoving();
        bridgeGame.move(length);
    }
}
