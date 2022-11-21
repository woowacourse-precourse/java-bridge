package bridge.domain;

import bridge.domain.constant.ExceptionMessage;

public class BridgeLength {
    private static final String INTEGER_REGEX = "^[0-9]*$";
    private static final int START_LENGTH_RANGE = 3;
    private static final int END_LENGTH_RANGE = 20;

    private final int length;

    private BridgeLength(int length) {
        this.length = length;
    }

    public static BridgeLength createBridgeLength(String inputLength) {
        validateNumeric(inputLength);
        int length = Integer.parseInt(inputLength);
        validateInputLength(length);
        return new BridgeLength(length);
    }

    private static void validateInputLength(int length) {
        if (length < START_LENGTH_RANGE || length > END_LENGTH_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_IN_RANGE);
        }
    }

    private static void validateNumeric(String inputLength) {
        if (!inputLength.matches(INTEGER_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER);
        }
    }

    public int getLength() {
        return this.length;
    }
}
