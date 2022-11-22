package bridge.command;

public enum MarkCommand {
    Possible("O"),
    Impossible("X");

    private String command;

    MarkCommand(String command) {
        this.command = command;
    }

    public String get() {
        return command;
    }
}
