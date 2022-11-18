package bridge.util;

public enum BridgeGameExceptionMessage {
    BRIDGE_SIZE_NUMBER_RANGE("다리의 길이는 3 이상 20 이하의 숫자여야 합니다.");

    private final String message;

    BridgeGameExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
