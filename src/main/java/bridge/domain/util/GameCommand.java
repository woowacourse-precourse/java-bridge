package bridge.domain.util;

public enum GameCommand {
    RESTART("R", true),
    QUIT("Q", false);

    private final String command;
    private final boolean state;

    GameCommand(String command, boolean state) {
        this.command = command;
        this.state = state;
    }

    public String getCommand() {
        return command;
    }

    public boolean isState() {
        return state;
    }
}
