package bridge.result;

public enum GameStatus {
    FAIL("fail", false, true),
    SUCCESS("Success", false, false),
    PROGRESS("Progress", true, false);

    private final String name;
    private final boolean isStopGame;
    private final boolean isFailGame;

    public String getName() {
        return name;
    }

    public boolean isFailGame() {
        return isFailGame;
    }

    public boolean isStopGame() {
        return isStopGame;
    }

    GameStatus(String name, boolean isFailGame, boolean isStopGame) {
        this.isFailGame = isFailGame;
        this.isStopGame = isStopGame;
        this.name = name;
    }
}
