package bridge.constant;

public enum ErrorMessage {
    NOT_NUMBER("숫자가 아닙니다."),
    NOT_BRIDGE_SIZE_RANGE("다리의 길이는 3이상 20이하입니다.");

    private final String message;
    private String errorMark = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return errorMark+message;
    }
}
