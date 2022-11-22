package bridge.model;

public enum Command {
    UP("U"),
    DOWN("D"),
    RESTART("R"),
    QUIT("Q"),
    SUCCESS("O"),
    FAILURE("X");

    private final String value;

    private Command(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
