package bridge.constant;

public enum GameCommand {
    USER_STEP_FOR_UPPER_LAYER("U"),
    USER_STEP_FOR_LOWER_LAYER("D"),
    COMMAND_FOR_RETRY("R"),
    COMMAND_FOR_QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
