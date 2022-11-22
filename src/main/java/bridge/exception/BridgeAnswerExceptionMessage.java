package bridge.exception;

public enum BridgeAnswerExceptionMessage {

    BRIDGE_ANSWER_EMPTY_EXCEPTION("[ERROR] 현재 다리에 대한 정답이 존재하지 않습니다.");

    private final String message;

    BridgeAnswerExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
