package bridge.enums;

public enum Commands {
    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q");

    private String command;

    Commands(String command) {
        this.command = command;
    }

    public static String getCommand(Commands commands) {
        return commands.command;
    }
}
