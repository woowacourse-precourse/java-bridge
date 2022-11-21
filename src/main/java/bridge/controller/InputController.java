package bridge.controller;

import bridge.view.InputView;

public class InputController {
    private final InputView inputView;

    public InputController(InputView inputView) {
        this.inputView = inputView;
    }

    public String getBridgeSize() {
        return inputView.readBridgeSize();
    }

    public String getMovingDirection() {
        return inputView.readMoving();
    }

    public String getGameCommand() {
        return inputView.readGameCommand();
    }
}
