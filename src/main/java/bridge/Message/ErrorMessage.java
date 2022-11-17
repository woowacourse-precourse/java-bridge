package bridge.Message;

public enum ErrorMessage {
    PREFIX("[ERROR] "),
    ONLY_NUMBER_ALLOWED("숫자만 입력이 가능합니다."),
    OUT_OF_BRIDGE_ALLOWED_SIZE("다리의 길이는 3~20칸이여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + message;
    }
}
