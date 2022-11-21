package bridge;

public enum ExceptionMessage {
    INPUT_WRONG_BRIDGE_LENGTH_MESSAGE("다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private final String ERROR_TAG = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = ERROR_TAG + message;
    }

    public void throwException() {
        throw new IllegalArgumentException(message);
    }
}
