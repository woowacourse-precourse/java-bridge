package bridge.validation;

import bridge.convertor.InputConvertor;
import bridge.resource.ErrorMessage;
import bridge.view.InputView;

public class BridgeSizeValidator {
    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;
    private static final InputView INPUT_VIEW = new InputView();

    public String sizeValidator() {
        try {
            String input = INPUT_VIEW.readBridgeSize();
            bridgeSizeValidation(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return sizeValidator();
        }
    }

    private void bridgeSizeValidation(String value) {
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
