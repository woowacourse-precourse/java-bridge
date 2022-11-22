package bridge.model.validation;

import bridge.model.constnce.CustomErrorMessage;

import java.util.Arrays;

public enum Command {
    RETRY("R"),
    QUIT("Q");

    private final String key;

    Command(String key) {
        this.key = key;
    }


    public boolean isRetry() {
        return this == RETRY;
    }

    public static Command of(String input) {
        validate(input);

        if (input.equals(RETRY.key)) {
            return RETRY;
        }
        return QUIT;
    }

    private static void validate(String input) {
        checkUppercase(input);
        checkCorrectKey(input);
    }

    private static void checkUppercase(String input) {
        if (!input.equals(input.toUpperCase())) {
            throw new IllegalArgumentException(CustomErrorMessage.IS_NOT_UPPERCASE.getMessage());
        }
    }

    private static void checkCorrectKey(String input) {
        if (isIncorrect(input)) {
            throw new IllegalArgumentException(CustomErrorMessage.INCORRECT_COMMAND_INPUT.getMessage());
        }
    }

    private static boolean isIncorrect(String input) {
        return Arrays.stream(Command.values()).noneMatch(e -> e.key.equals(input));
    }

}
