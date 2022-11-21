package bridge.exception;

public abstract class UserException {

    public abstract void checkException(String userInput);

    void isEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionCode.IS_EMPTY.getMessage());
        }
    }
}
