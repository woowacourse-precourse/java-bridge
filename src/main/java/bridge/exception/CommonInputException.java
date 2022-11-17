package bridge.exception;

public class CommonInputException {

    private static final String NO_INPUT_ERROR_MESSAGE = "[ERROR] 입력값이 없습니다.";

    private CommonInputException() {
    }

    public static void validate(String input) {
        checkEmptyInput(input);
    }

    private static void checkEmptyInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(NO_INPUT_ERROR_MESSAGE);
        }
    }
}
