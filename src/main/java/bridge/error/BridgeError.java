package bridge.error;

public enum BridgeError implements Error {
    INVALID_BRIDGE_NUMBER("올바르지 않은 문자입니다."),
    ;

    BridgeError(String message) {
        this.message = message;
    }

    private final String message;

    @Override
    public String getMessage() {
        return message;
    }
}
