package bridge.model;

public enum GameCommand {
    RETRY("R"), QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public boolean isSame(String command) {
        return this.command.equals(command);
    }

    public String getDirection() {
        return command;
    }
}
