package bridge.controller;

import bridge.ValidationException;
import bridge.model.Bridge;
import bridge.model.User;
import bridge.view.InputView;

public class BridgeInputController {
    InputView inputView;

    public BridgeInputController(InputView inputView) {

        this.inputView = inputView;
    }

    public int enterBridgeSize() {

        return inputView.readBridgeSize();
    }


    public String enterUserMoving() {

        return inputView.readMoving();
    }

    public String enterUserCommand() {

        return inputView.readGameCommand();
    }
}
