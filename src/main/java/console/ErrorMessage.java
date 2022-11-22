package console;

public enum ErrorMessage {
    ERROR_NUMBER("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_STRING("[ERROR] 숫자를 입력하여 주세요."),
    ERROR_UP_DOWN("[ERROR] U 또는 D를 입력하여 주세요."),
    ERROR_RETRY("[ERROR] R 또는 Q를 입력하여 주세요.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
