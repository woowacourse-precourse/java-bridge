package message;

public enum ErrorMessage {
    Bridge_Size("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
