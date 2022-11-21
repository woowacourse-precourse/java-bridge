package bridge.validator;

public class ValidateBridgeSize implements Validator {
    private final String INPUT_BRIDGE_SIZE_INTEGER_ERROR_MESSAGE = "정수가 아닌 값이 입력되었습니다.";
    private final String INPUT_BRIDGE_SIZE_RANGE_ERROR_MESSAGE = "3 이상 20 이하의 정수를 입력해야 합니다.";
    private final int MINIMUM_BRIDGE_SIZE = 3;
    private final int MAXIMUM_BRIDGE_SIZE = 20;

    @Override
    public void validate(String readInput) {
        validateBridgeSizeIsNumber(readInput);
        validateBridgeSizeRange(readInput);
    }

    private void validateBridgeSizeIsNumber(String readBridgeSize) {
        try {
            Integer.parseInt(readBridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_BRIDGE_SIZE_INTEGER_ERROR_MESSAGE);
        }
    }

    private void validateBridgeSizeRange(String readBridgeSize) {
        if (!validBridgeSize(Integer.parseInt(readBridgeSize))) {
            throw new IllegalArgumentException(INPUT_BRIDGE_SIZE_RANGE_ERROR_MESSAGE);
        }
    }

    private boolean validBridgeSize(int readBridgeSize) {
        return MINIMUM_BRIDGE_SIZE <= readBridgeSize && readBridgeSize <= MAXIMUM_BRIDGE_SIZE;
    }

}
