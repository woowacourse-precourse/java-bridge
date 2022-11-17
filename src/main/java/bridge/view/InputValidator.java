package bridge.view;

public class InputValidator {

    private static final int VALID_BRIDGE_SIZE_LOWER_BOUND = 3;
    private static final int VALID_BRIDGE_SIZE_UPPER_BOUND = 20;
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "올바르지 않은 숫자 형식입니다.";
    private static final String INVALID_BRIDGE_RANGE_MESSAGE = "다리의 길이는 3에서 20 사이의 값이어야 합니다.";

    public void validateBridgeSize(String inputSize) {
        Integer size = toInteger(inputSize);
        validateBridgeSizeRange(size);
    }

    private Integer toInteger(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }

    private void validateBridgeSizeRange(Integer size) {
        if (size < VALID_BRIDGE_SIZE_LOWER_BOUND || VALID_BRIDGE_SIZE_UPPER_BOUND < size) {
            throw new IllegalArgumentException(INVALID_BRIDGE_RANGE_MESSAGE);
        }
    }
}
