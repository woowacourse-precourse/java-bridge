package bridge.command;

public enum Retry {

    YES("R"),
    NO("Q"),
    ;

    private final String command;

    Retry(final String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
