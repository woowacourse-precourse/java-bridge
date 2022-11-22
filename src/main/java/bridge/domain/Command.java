package bridge.domain;

import java.util.Arrays;

public enum Command {
    RETRY("R", true),
    QUIT("Q", false);
    private String command;
    private boolean isRetry;

    Command(String command, boolean isRetry) {
        this.command = command;
        this.isRetry = isRetry;
    }

    public boolean getIsRetry() {
        return this.isRetry;
    }

    public static Command getBySymbol(String command) {
        return Arrays.stream(values())
                .filter(Command -> command.equals(Command.command))
                .findFirst()
                .orElseThrow();
    }
}
