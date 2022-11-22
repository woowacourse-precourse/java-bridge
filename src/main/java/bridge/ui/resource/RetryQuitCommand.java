package bridge.ui.resource;

public enum RetryQuitCommand {
    RETRY("R"),
    QUIT("Q");
    private String command;
    private int value;

    RetryQuitCommand(String command) {
        this.command = command;
    }
    public String command() {
        return command;
    }

}
