package bridge.constant;

public enum RetryCode {
    RETRY("R"),
    QUIT("Q");

    private final String code;

    RetryCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}