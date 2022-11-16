package bridge;

public enum ErrorMessage {
    IS_NOT_NUMBER("[ERROR] 숫자만 입력 가능합니다."),
    IS_NOT_IN_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
