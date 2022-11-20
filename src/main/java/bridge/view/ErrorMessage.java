package bridge.view;

public enum ErrorMessage {
    ONLY_NUMBER_POSSIBLE("[ERROR] 다리 길이는 숫자만 입력 가능합니다.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }
}
