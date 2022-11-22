package bridge.command;

import bridge.logger.Logger;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Retry {

    YES("R"),
    NO("Q"),
    ;

    private final String command;

    Retry(final String command) {
        this.command = command;
    }

    public static Retry commandOf(final String command) {
        try {
            return Arrays.stream(values())
                    .filter(value -> value.command.equals(command))
                    .findAny()
                    .orElseThrow();
        } catch (NoSuchElementException e) {
            Logger.error("invalid command", command);
            throw new IllegalArgumentException();
        }
    }

    public String getCommand() {
        return command;
    }
}
