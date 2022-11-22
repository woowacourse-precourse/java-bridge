package bridge.controller;

import bridge.InputView;
import bridge.view.View;

public class BridgeGameController {
    public static void setGame() {
        View.gameStartMessage();
        int startNumber = 1;

        while (startNumber != 0) {
            View.requestBridgeLengthMessage();
            try {
                InputView inputView = new InputView();
                int bridgeSize = inputView.readBridgeSize();
                startNumber = 0;
            } catch (IllegalArgumentException e) {
                View.exceptionMessage(e);
                startNumber = 1;
            }
        }
    }
}
