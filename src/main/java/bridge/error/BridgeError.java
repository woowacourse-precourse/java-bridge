package bridge.error;

public enum BridgeError implements Error {
    INVALID_BRIDGE_NUMBER("올바르지 않은 문자입니다."),
    END_OF_BRIDGE("다리 끝에 도달해 더 이상 이동할 수 없습니다."),
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
