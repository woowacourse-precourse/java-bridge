package bridge;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private String command;

    GameCommand(String command) {
        this.command = command;
    }

    public boolean isEqual(String command) {
        return this.command.equals(command);
    }
}
