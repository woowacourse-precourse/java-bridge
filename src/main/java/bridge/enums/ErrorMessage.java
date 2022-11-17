package bridge.enums;

public enum ErrorMessage {

    ER_BRIDGE_LENGTH_INPUT("[ERROR] 다리의 길이는 3이상 20이하의 정수 입니다.");
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}