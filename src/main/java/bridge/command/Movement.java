package bridge.command;

import bridge.logger.Logger;

import java.util.Arrays;
import java.util.NoSuchElementException;

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

    public static Movement indexOf(final int index) {
        try {
            return Arrays.stream(values())
                    .filter(value -> value.index == index)
                    .findAny()
                    .orElseThrow();
        } catch (NoSuchElementException e) {
            Logger.error("invalid index", index);
            throw new IllegalArgumentException();
        }
    }

    public String getCommand() {
        return command;
    }
}
