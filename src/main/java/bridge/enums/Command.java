package bridge.enums;

public enum Command {
    RESTART_COMMAND("R"),
    QUIT_COMMAND("Q"),
    ;
    private final String command;

    Command(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return command;
    }
}
