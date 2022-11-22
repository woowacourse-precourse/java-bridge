package bridge.Enum;

public enum PlayerInput {
    UP("U"),
    DOWN("D"),
    RESTART("R"),
    QUIT("Q");

    private final String value;
    PlayerInput(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
