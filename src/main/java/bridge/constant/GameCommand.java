package bridge.constant;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String key;

    GameCommand(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
