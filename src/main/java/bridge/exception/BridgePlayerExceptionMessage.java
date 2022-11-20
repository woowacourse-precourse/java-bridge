package bridge.exception;

public enum BridgePlayerExceptionMessage {

    BRIDGE_SIZE_SIZE_EXCEPTION("[ERROR] 다리 길이는 0일 수 없습니다.");

    private final String message;

    BridgePlayerExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
