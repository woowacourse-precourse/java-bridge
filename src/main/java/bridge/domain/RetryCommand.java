package bridge.domain;

import java.util.Arrays;

import static bridge.exception.ExceptionMessage.*;

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
                .orElseThrow(() -> new IllegalArgumentException(NOT_RETRY_COMMAND_EXCEPTION.getMessage()));
    }

    public boolean isRetry() {
        return command.equals(RETRY.getCommand());
    }

    public String getCommand() {
        return command;
    }
}
