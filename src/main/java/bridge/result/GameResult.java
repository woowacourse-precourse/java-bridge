package bridge.result;

public enum GameResult {
    FAIL("실패", true),
    SUCCESS("성공", true),
    PROGRESS("진행", false),
    UNKNOWN("알수없음", true);

    private final String name;
    private final boolean isStopGame;

    @Override
    public String toString() {
        return name;
    }

    public boolean isStopGame() {
        return !isStopGame;
    }

    GameResult(String name, boolean isStopGame) {
        this.isStopGame = isStopGame;
        this.name = name;
    }
}
