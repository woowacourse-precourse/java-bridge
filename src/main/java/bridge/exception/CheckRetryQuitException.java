package bridge.exception;

public class CheckRetryQuitException extends IllegalArgumentException {
    public static final String ENTER_R_OR_Q = "[ERROR] R or Q 를 입력해 주세요";
    public CheckRetryQuitException() {
        super(ENTER_R_OR_Q);
    }
}
