package bridge.model.constant;

public enum GameCommand {
    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q"),
    CAN_CROSS("O"),
    CANNOT_CROSS("X"),
    UNKNOWN(" ");

    private final String value;

    GameCommand(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
