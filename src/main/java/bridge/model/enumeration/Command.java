package bridge.model.enumeration;

public enum Command {

    UP("U"),
    DOWN("D"),
    BAR("|"),
    POSSIBLE(" O "),
    IMPOSSIBLE(" X "),
    BLANK("   "),
    RESTART("R"),
    QUIT("Q");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public String getMessage() {
        return command;
    }
}
