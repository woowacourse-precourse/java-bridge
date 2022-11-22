package bridge.exception;

public class RetryValueException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE_RETRY_VALUE = "[ERROR] 재시도 여부는 %s 또는 %s 만 입력해야 됩니다.";

    public RetryValueException(String retry, String quit) {
        super(String.format(EXCEPTION_MESSAGE_RETRY_VALUE, retry, quit));
    }
}
