package bridge.domain.validation;

public class InputValidator {

    static final String INPUT_ONLY_NUMBERS = "숫자만 입력해 주세요.";

    private InputValidator() {
    }

    public static void validateThisIsNumber(String inputValue) {
        final String REGEX_FOR_NUMBER = "^\\d+$";
        if (!inputValue.matches(REGEX_FOR_NUMBER)) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBERS);
        }
    }
}
