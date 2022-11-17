package bridge.controller;

import bridge.InputView;
import bridge.view.Print;

public class BridgeGameController {

    public static void setGame() {
        Print.gameStartMessage();
        int startNumber = 1;
        while (startNumber != 0) {
            Print.requestBridgeLengthMessage();
            try {
                InputView inputView = new InputView();
                int bridgeSize = inputView.readBridgeSize();
                startNumber = 0;
            } catch (IllegalArgumentException e) {
                Print.exceptionMessage(e);
                startNumber = 1;
            }
        }


    }
}
