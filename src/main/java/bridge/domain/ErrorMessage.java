package bridge.domain;

public enum ErrorMessage {
    WRONG_INPUT("올바른 값을 입력해주세요."),
    BRIDGE_SIZE_RANGE("다리의 길이는 3 이상 20 이하여야 합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
