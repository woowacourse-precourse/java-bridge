package bridge.model;

public enum RetryCommand {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    RetryCommand(String command) {
        this.command = command;
    }

    public static boolean equals(String commandInput, RetryCommand retryCommand) {
        return retryCommand.command
                .equals(commandInput);
    }
}
