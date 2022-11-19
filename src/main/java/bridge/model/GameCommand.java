package bridge.model;

public enum GameCommand {
    RE_GAME("R"), QUIT("Q");

    private final String value;

    GameCommand(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
