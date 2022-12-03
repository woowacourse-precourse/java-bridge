package bridge.model;

import static bridge.util.ErrorMessage.ERROR_GAME_COMMAND_INPUT;

import java.util.Arrays;

public enum RetryAndQuit {
    RETRY("R"),
    QUIT("Q");
    private final String command;

    RetryAndQuit(String command) {
        this.command = command;
    }


    public static RetryAndQuit from(String input) {
        return Arrays.stream(RetryAndQuit.values())
                .filter(command -> command.command.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_GAME_COMMAND_INPUT));
    }

    public boolean isRetry() {
        return this == RetryAndQuit.RETRY;
    }

}
