package bridge;

public enum GameStatus {
    ONGOING(0),
    WIN(1),
    LOSE(2);

    private final int statusCode;

    GameStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getValue() {
        return statusCode;
    }
}
