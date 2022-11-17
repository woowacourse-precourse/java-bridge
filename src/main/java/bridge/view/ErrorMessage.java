package bridge.view;

public enum ErrorMessage {
    INVALID_BRIDGE_SIZE("[ERROR] 다리 길이는 %d부터 %d 사이의 숫자여야 합니다.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormatMessage(int firstNumber, int secondNumber) {
        return String.format(message, firstNumber, secondNumber);
    }
}
