package bridge.exception;

public enum BridgeGameEndTypeExceptionMessage {

    NO_SUCH_BRIDGE_GAME_END_TYPE_EXCEPTION("[ERROR] - 존재하지 않는 게임 종료 타입 입력값 입니다.");

    private final String message;

    BridgeGameEndTypeExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
