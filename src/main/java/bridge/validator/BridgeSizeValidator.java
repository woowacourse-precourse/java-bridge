package bridge.validator;

public class BridgeSizeValidator {
    private static final int BRIDGE_SIZE_MIN = 3;
    private static final int BRIDGE_SIZE_MAX = 20;

    private static final String ERROR_BRIDGE_SIZE_NUMBER = "[ERROR] 숫자를 입력해야 합니다.";
    private static final String ERROR_BRIDGE_SIZE_RANGE = "[ERROR] 다리 길이는 3~20 이어야 합니다.";

    public void validate(String size) {
        if (!isNumber(size)) {
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE_NUMBER);
        }
        validateRange(size);
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void validateRange(String input) {
        int size = Integer.parseInt(input);
        if (size < BRIDGE_SIZE_MIN || size > BRIDGE_SIZE_MAX) {
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE_RANGE);
        }
    }
}
