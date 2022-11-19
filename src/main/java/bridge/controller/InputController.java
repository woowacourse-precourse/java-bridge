package bridge.controller;

import bridge.model.InputValidator;
import bridge.view.InputView;

public class InputController {

    InputView inputView = new InputView();
    InputValidator inputValidator = new InputValidator();

    public int inputBridgeSize() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            inputValidator.BridgeSize(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage() + "\n");
            return inputBridgeSize();
        }
    }
}
