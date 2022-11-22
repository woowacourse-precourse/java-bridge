package bridge.exception;

public class InvalidRangeNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 3 이상 20 이하의 수를 입력해주세요.";

    public InvalidRangeNumberException() {
        super(ERROR_MESSAGE);
    }
}
