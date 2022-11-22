package bridge.command;

import bridge.logger.Logger;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public enum Movement {

    UP("U", 1),
    DOWN("D", 0),
    ;

    private final String command;

    private final int index;
    Movement(
            final String command,
            final int index
    ) {
        this.command = command;
        this.index = index;
    }

    public static Movement commandOf(final String command) {
        try {
            return of(value -> value.command.equals(command));
        } catch (NoSuchElementException e) {
            Logger.error("invalid command", command);
            throw new IllegalArgumentException();
        }
    }

    public static Movement indexOf(final int index) {
        try {
            return of(value -> value.index == index);
        } catch (NoSuchElementException e) {
            Logger.error("invalid index", index);
            throw new IllegalArgumentException();
        }
    }

    private static Movement of(Predicate<Movement> predicate) {
        return Arrays.stream(values())
                .filter(predicate)
                .findAny()
                .orElseThrow();
    }

    public String getCommand() {
        return command;
    }
}
