package bridge.result;

public enum GameStatus {
    FAIL("실패", true),
    SUCCESS("성공", true),
    PROGRESS("진행", false);

    private final String name;
    private final boolean isStopGame;

    @Override
    public String toString() {
        return name;
    }

    public boolean isStopGame() {
        return isStopGame;
    }

    GameStatus(String name, boolean isStopGame) {
        this.isStopGame = isStopGame;
        this.name = name;
    }
}
