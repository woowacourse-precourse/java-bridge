package bridge.enummodel;

public enum CommandEnum {
    UP("U"),
    DOWN("D"),
    RESTART_COMMAND("R"),
    QUIT("Q");

    private final String value;

    CommandEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
