package bridge.controller;

import bridge.InputView;
import bridge.utils.message.FixedMessage;

public class BridgeController {
    private final InputView inputView = new InputView();

    public void startGame() {
        System.out.println(FixedMessage.GAME_START.getMessage() + "\n");
        inputView.readBridgeSize();
    }
}
