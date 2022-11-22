package bridge.exception;

public class TotalTryMaxException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE_OVER_NUMBER = "[ERROR] 최대 시도 횟수를 넘었습니다!";

    public TotalTryMaxException() {
        super(EXCEPTION_MESSAGE_OVER_NUMBER);
    }
}
