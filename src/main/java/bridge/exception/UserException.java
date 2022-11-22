package bridge.exception;

public abstract class UserException {

    public abstract void checkException(String userInput);

    void isEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionCode.IS_EMPTY.getMessage());
        }
    }

    void isBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ExceptionCode.IS_BLANK.getMessage());
        }
    }

    void hasBlank(String input) {
        if (input.length() != input.trim().length()) {
            throw new IllegalArgumentException(ExceptionCode.HAS_BLANK.getMessage());
        }
    }

    void isNotLengthOne(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(ExceptionCode.IS_NOT_LENGTH_ONE.getMessage());
        }
    }

    void isLowerCase(String input) {
        char letter = input.charAt(0);
        if (letter > 96 && letter < 123) {
            throw new IllegalArgumentException(ExceptionCode.IS_LOWER_CASE.getMessage());
        }
    }
}
