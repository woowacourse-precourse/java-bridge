package bridge.constant;

public enum RetryCode {
    RETRY("R"),
    QUIT("Q");

    private final String retryCode;

    RetryCode(String retryCode) {
        this.retryCode = retryCode;
    }

    public String getRetryCode() {
        return retryCode;
    }
}
