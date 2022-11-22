package bridge.domain;

import java.util.Arrays;

public enum RetryQuit {
    RETRY("R"),
    QUIT("Q");

    private String command;

    RetryQuit(String command) {
        this.command = command;
    }

    public static RetryQuit convert(String command) {
        return Arrays.stream(RetryQuit.values())
                .filter(rq -> rq.command.equals(command))
                .findAny()
                .orElse(null);
    }

    public String getCommand() {
        return this.command;
    }
}
