package bridge;

public class RetryCommandParameter {
    private static final String QUIET = "Q";
    private static final String RETRY = "R";

    private final String command;

    public RetryCommandParameter(String command) {
        this.command = command;
    }

    public boolean quiet() {
        return command.matches(QUIET);
    }

    public String getCommand() {
        return command;
    }
}
