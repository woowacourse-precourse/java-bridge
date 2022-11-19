package bridge.constant;

public enum ErrorMessage {
    INPUT_NUMBER_ERROR("다리 길이는 2,147,483,648보다 작은 양의 정수만 입력해주세요."),
    BRIDGE_SIZE_ERROR("다리 길이는 3부터 20 사이의 숫자여야 합니다.");

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
