package bridge;

public enum GameCommand {
    QUIT("Q"),
    RETRY("R");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return command;
    }
}
