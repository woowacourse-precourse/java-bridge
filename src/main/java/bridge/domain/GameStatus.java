package bridge.domain;

public enum GameStatus {
    GAME_OVER("실패"),
    GAME_CLEAR("성공"),
    PLAYING("진행중");
    private final String message;

    GameStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
