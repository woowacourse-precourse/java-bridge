package bridge.command;

import bridge.logger.Logger;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Retry {

    YES("R", true),
    NO("Q", false),
    ;

    private final String command;

    private final boolean value;

    Retry(
            final String command,
            final boolean value
    ) {
        this.command = command;
        this.value = value;
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

    public boolean getValue() {
        return value;
    }
}
