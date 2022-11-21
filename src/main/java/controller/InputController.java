package controller;

import view.InputView;

public class InputController {
    InputView inputView = new InputView();

    public int getBridgeSize() {
        return inputView.readBridgeSize();
    }

    public String getMoving() {
        return inputView.readMoving();
    }

    public String getCommand() {
        return inputView.readGameCommand();
    }
}
