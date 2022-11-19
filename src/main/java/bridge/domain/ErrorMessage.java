package bridge.domain;

public enum ErrorMessage {
    SIZE_TYPE("[ERROR] 다리 길이는 숫자이어야 합니다."),
    SIZE_RANGE("[ERROR] 다리 길이는 3~20 사이의 숫자이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
