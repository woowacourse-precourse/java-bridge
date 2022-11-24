package bridge.view;

import bridge.messages.ErrorMessage;

public class InputSizeValidator {
    private static final int MIN_NUM = 3;
    private static final int MAX_NUM = 20;
    private static final int ZERO = 0;

    public static void validateInputSizeException(String inputSize) {
        validateInputSizeNull(inputSize);
        validateInputSizeType(inputSize);
        validateInputSize(Integer.parseInt(inputSize));
    }

    private static void validateInputSize(int bridgeSize) {
        if (bridgeSize < MIN_NUM || bridgeSize > MAX_NUM) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_INPUT_RANGE.getErrorMessage());
        }
    }

    private static void validateInputSizeType(String inputSize) {
        final String regex = "[0-9]+";
        if (!inputSize.matches(regex)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_INPUT_TYPE.getErrorMessage());
        }
    }

    private static void validateInputSizeNull(String inputSize) {
        if (inputSize.length() == ZERO) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }
}
