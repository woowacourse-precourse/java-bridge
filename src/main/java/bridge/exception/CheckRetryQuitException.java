package bridge.exception;

public class CheckRetryQuitException extends IllegalArgumentException {
    public CheckRetryQuitException() {
        super("[ERROR] R or Q 를 입력해 주세요");
    }
}
