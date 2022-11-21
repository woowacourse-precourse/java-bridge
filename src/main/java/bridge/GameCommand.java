package bridge;

public enum GameCommand {
    RETRY("R"), QUIT("Q");

    private final String value;

    GameCommand(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
