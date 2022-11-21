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
}
