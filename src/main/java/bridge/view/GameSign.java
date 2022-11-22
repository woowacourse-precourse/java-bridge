package bridge.view;

public enum GameSign {
    UP_MOVING("U"),
    DOWN_MOVING("D"),
    MOVING_SUCCESS(" O "),
    MOVING_FAIL(" X "),
    MOVING_NOT("   "),
    RETRY("R");
    private final String gameSign;

    GameSign(String message) {
        this.gameSign = message;
    }

    public String getMessage() {
        return gameSign;
    }
}
