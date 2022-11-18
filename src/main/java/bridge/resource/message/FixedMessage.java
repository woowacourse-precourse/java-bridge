package bridge.resource.message;

public enum FixedMessage {
    GAME_START("다리 건너기 게임을 시작합니다.");

    private final String message;

    FixedMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
