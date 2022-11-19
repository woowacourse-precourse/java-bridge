package bridge.constant;

public enum ErrorMessage {
    INPUT_NUMBER_ERROR("다리 길이는 3부터 20 사이의 숫지여야 합니다.");

    private static final String ERROR_FORMAT = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR_FORMAT + message;
    }
}
