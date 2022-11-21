package bridge.validation;

import bridge.convertor.InputConvertor;
import bridge.resource.ErrorMessage;
import bridge.resource.GameConstant;

public class BridgeSizeValidator {

    public String sizeValidator(String input) throws IllegalArgumentException {
        bridgeSizeValidation(input);
        return input;
    }

    private void bridgeSizeValidation(String value) {
        if (checkBridgeSize(convertInputToNumber(value))) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_ERROR);
    }

    private int convertInputToNumber(String value) {
        try {
            return InputConvertor.inputParseNumber(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NO_NUMBER_ERROR);
        }
    }

    private boolean checkBridgeSize(int size) {
        return GameConstant.BRIDGE_MIN_SIZE <= size && size <= GameConstant.BRIDGE_MAX_SIZE;
    }
}
