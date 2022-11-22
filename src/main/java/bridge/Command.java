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

    public static boolean contains(String command) {
        return Arrays.stream(Command.values())
            .map(Command::getCommand)
            .collect(Collectors.toList())
            .contains(command);
    }

    public String getCommand() {
        return this.command;
    }
}
