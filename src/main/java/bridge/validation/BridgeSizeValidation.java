package bridge.validation;

import bridge.convertor.InputConvertor;
import bridge.message.ErrorMessage;

public class BridgeSizeValidation {
    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;

    public void bridgeSizeValidation(String value) {
        if (checkBridgeSize(convertInputToNumber(value))) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_ERROR);
    }

    public int convertInputToNumber(String value) {
        try {
            return InputConvertor.inputParseNumber(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NO_NUMBER_ERROR);
        }
    }

    public boolean checkBridgeSize(int size) {
        return BRIDGE_MIN_SIZE <= size && size <= BRIDGE_MAX_SIZE;
    }
}
