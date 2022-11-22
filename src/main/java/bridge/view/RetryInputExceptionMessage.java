package bridge.view;

public enum RetryInputExceptionMessage {

    SMALL_LETTER_EXCEPTION_MESSAGE("[ERROR] 대문자만 입력가능합니다."),
    NOT_SUITABLE_ALPHABET_EXCEPTION_MESSAGE("[ERROR] R과 Q만 입력가능합니다.");

    public String retryInputExceptionMessage;

    RetryInputExceptionMessage(String retryInputExceptionMessage) {
        this.retryInputExceptionMessage = retryInputExceptionMessage;
    }

    public String getRetryInputExceptionMessage() {
        return retryInputExceptionMessage;
    }
}
