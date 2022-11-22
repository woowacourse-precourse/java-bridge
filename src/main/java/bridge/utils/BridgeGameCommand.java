package bridge.utils;

public enum BridgeGameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    BridgeGameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
