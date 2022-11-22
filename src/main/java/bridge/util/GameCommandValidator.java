package bridge.util;

import bridge.domain.GameCommand;

import java.util.Arrays;

import static bridge.exception.ExceptionType.INPUT_WRONG_COMMAND;

public enum GameCommandValidator {
    UNKNOWN_COMMAND((String command) -> {
        if (isNotExistCommand(command)) {
            throw new IllegalArgumentException(INPUT_WRONG_COMMAND.getMessage());
        }
    }),
    ;

    private final Validator<String> validator;

    GameCommandValidator(final Validator<String> validator) {
        this.validator = validator;
    }

    public static void validate(final String command) {
        Arrays.stream(values()).forEach(v -> v.validator.validate(command));
    }

    private static boolean isNotExistCommand(final String command) {
        return !GameCommand.contains(command);
    }
}
