package bridge.domain;

import java.util.Arrays;

public enum BridgeGameRetryCommand {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    BridgeGameRetryCommand(String command) {
        this.command = command;
    }

    public static BridgeGameRetryCommand getRetryCommandWithCommand(String command) {
        return Arrays.stream(BridgeGameRetryCommand.values())
                .filter(retryCommand -> retryCommand.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(""));
    }
}
