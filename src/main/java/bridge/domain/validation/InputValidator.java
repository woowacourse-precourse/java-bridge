package bridge.domain.validation;

public class InputValidator {

    static final String INPUT_ONLY_NUMBERS = "숫자만 입력해 주세요.";
    static final String NOT_VALID_RANGE_OF_BRIDGE_SIZE = "다리의 길이는 3 이상 20 이하여야 합니다.";

    private InputValidator() {
    }

    public static void validateThisIsNumber(String inputValue) {
        final String REGEX_FOR_NUMBER = "^\\d+$";
        if (!inputValue.matches(REGEX_FOR_NUMBER)) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBERS);
        }
    }

    public static void validateBridgeSize(int size) {
        final int MIN_SIZE = 3;
        final int MAX_SIZE = 20;
        if (size < MIN_SIZE || MAX_SIZE < size) {
            throw new IllegalArgumentException(NOT_VALID_RANGE_OF_BRIDGE_SIZE);
        }
    }
}
