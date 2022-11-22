package bridge;

public enum GameStatus {
    GAME_OVER("실패", true),
    GAME_CLEAR("성공", true),
    PLAYING("진행중", false);
    private final String message;
    private final boolean isOver;

    GameStatus(String message, boolean isOver) {
        this.message = message;
        this.isOver = isOver;
    }

    public String getMessage() {
        return message;
    }

    public boolean isOver() {
        return isOver;
    }
}
