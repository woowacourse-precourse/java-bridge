package bridge;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Command {
    RETRY("R"),
    END("Q");

    private final String command;

    Command(String command) {
        this.command = command;
    }
}
