package bridge.domain;

import java.util.Arrays;

public enum RetryCommand {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    RetryCommand(String command) {
        this.command = command;
    }

    public static RetryCommand getRetryCommandWithCommand(String command) {
        return Arrays.stream(RetryCommand.values())
                .filter(retryCommand -> retryCommand.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(""));
    }

    public boolean isRetry() {
        return command.equals(RETRY.getCommand());
    }

    public String getCommand() {
        return command;
    }
}
