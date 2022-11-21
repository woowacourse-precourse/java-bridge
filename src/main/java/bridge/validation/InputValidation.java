package bridge.validation;

import static bridge.constant.BridgeErrorMessage.BRIDGE_LENGTH_IS_NOT_DIGIT_ERROR_MESSAGE;

import bridge.view.InputView;

public class InputValidation {

    private final InputView inputView;

    public InputValidation(InputView inputView) {
        this.inputView = inputView;
    }

    public boolean isValid() {
        if(!inputView.readBridgeSize().chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_IS_NOT_DIGIT_ERROR_MESSAGE);
        }
    }
}
