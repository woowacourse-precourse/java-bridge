package bridge.type;

public enum ErrorMessage {

    ERROR("[ERROR] "),

    BRIDGE_SIZE_NUMERIC(ERROR.getMessage() + "다리 길이는 숫자만 입력 가능합니다."),

    BRIDGE_SIZE_BOUNDARY(ERROR.getMessage() + "다리 길이는 3이상 20이하여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
