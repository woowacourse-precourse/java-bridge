package bridge.domain.game;

public enum GameMode {
    RETRY("R"),
    QUIT("Q");

    private final String retryKey;

    public String getKey() {
        return retryKey;
    }

    GameMode(String retryKey) {
        this.retryKey = retryKey;
    }

}
