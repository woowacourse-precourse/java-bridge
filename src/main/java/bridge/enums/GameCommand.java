package bridge.enums;

public enum GameCommand {

    RETRY("R"),
    END("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
