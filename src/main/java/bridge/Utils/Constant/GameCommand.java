package bridge.Utils.Constant;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return command;
    }
}
