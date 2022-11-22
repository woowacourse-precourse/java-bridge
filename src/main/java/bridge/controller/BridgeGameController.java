package bridge.controller;

import bridge.InputView;
import bridge.view.View;

public class BridgeGameController {
    public static void setGame() {
        View.gameStartMessage();

        View.requestBridgeLengthMessage();
        try{
            InputView inputView = new InputView();
            int bridgeSize = inputView.readBridgeSize();
        }catch (IllegalArgumentException e) {
            View.exceptionMessage(e);
        }
    }
}
