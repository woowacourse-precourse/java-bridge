package bridge.domain.bridge;

public class BridgeSize {
    public static final String ERROR_INPUT_IS_NUMBER = "[ERROR] 다리의 길이는 숫자만 입력 가능합니다!";
    public static final String ERROR_SIZE_IN_RANGE = "[ERROR] 다리의 길이는 3이상 20이하입니다.";
    private static final Integer MIN_SIZE = 3;
    private static final Integer MAX_SIZE = 20;

    private final Integer size;

    public BridgeSize(final String input) {
        validateInputIsNumber(input);

        var size = Integer.parseInt(input);

        validateSizeGreaterThanMinSie(size);
        validateSizeLessThanMaxSize(size);
        this.size = size;
    }

    public Integer size() {
        return this.size;
    }

    private void validateSizeLessThanMaxSize(int size) {
        if (size > MAX_SIZE) {
            throw new IllegalArgumentException(ERROR_SIZE_IN_RANGE);
        }
    }

    private void validateSizeGreaterThanMinSie(final Integer size) {
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException(ERROR_SIZE_IN_RANGE);
        }
    }

    private void validateInputIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_NUMBER);
        }
    }
}
