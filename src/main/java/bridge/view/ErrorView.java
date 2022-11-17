package bridge.view;

public enum ErrorView {
    INVALID_BRIDGE_LENGTH("다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private final String message;

    ErrorView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
