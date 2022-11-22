package bridge.util;

public enum Command {
    RESTART("R", true),
    QUIT("Q", false);

    private final String command;
    private final boolean status;

    Command(String command, boolean status) {
        this.command = command;
        this.status = status;
    }

    public String getCommand() {
        return command;
    }

    public boolean getStatus() {
        return status;
    }
}