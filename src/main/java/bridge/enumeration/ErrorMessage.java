package bridge.enumeration;

public enum ErrorMessage {
    BRIDGE_OUT_OF_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private final String errorMessage;
    private final String errorPrefix = "[ERROR] ";

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorPrefix + this.errorMessage;
    }
}
