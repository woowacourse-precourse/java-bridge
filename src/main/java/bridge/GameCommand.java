package bridge;

import java.util.Arrays;

public enum GameCommand {
    RESTART("R"),
    QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand of(String input) {
        validate(input);
        return Arrays.stream(values())
                .filter(command -> command.isSameWith(input))
                .findFirst()
                .get();
    }

    private static void validate(String command) {
        if (command.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BLANK_INPUT);
        }
        if (isInvalidCommand(command)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COMMAND_INPUT);
        }

    }

    private static boolean isInvalidCommand(String command) {
        return !command.equals(RESTART.command) && !command.equals(QUIT.command);
    }

    private boolean isSameWith(String command) {
        return this.command.equals(command);
    }
}
