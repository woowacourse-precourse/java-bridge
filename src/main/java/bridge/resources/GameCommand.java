package bridge.resources;

public enum GameCommand {
    RESTART("R"),
    QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public boolean isEqual(String command) {
        return this.command.equals(command);
    }
}
