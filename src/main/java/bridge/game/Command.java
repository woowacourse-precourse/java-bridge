package bridge.game;

public enum Command {
    RETRY("R"),
    QUIT("Q"),
    ;

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public String value() {
        return command;
    }

    public boolean equals(String command) {
        return command.equals(this.command);
    }
}
