package bridge.model;

public enum GameMessage {
    GAME_START("다리 건너기 게임을 시작합니다.");

    private final String message;
    private GameMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }
}
