package bridge.domain;

public enum Command {
    RETRY("R"),
    END("Q");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public static Command get(String input) {
        if (input.equals("R")) {
            return RETRY;
        }
        return END;
    }
}
