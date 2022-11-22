package bridge.exception;

public enum BridgeTypeExceptionMessage {
    READ_WRONG_TYPE_EXCEPTION("[ERROR] - 잘못된 다리 칸 입력입니다.");

    private final String message;

    BridgeTypeExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
