package bridge.error;

public enum BridgeError implements Error {
    INVALID_BRIDGE_NUMBER("올바르지 않은 문자입니다."),
    ;

    private final String message;

    BridgeError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
