package bridge.util;

import bridge.domain.Moving;

import java.util.Arrays;

import static bridge.exception.ExceptionType.INPUT_WRONG_DIRECTION;

public enum MoveDirectionValidator {
    UNKNOWN_DIRECTION((String direction) -> {
        if (isNotExistDirection(direction)) {
            throw new IllegalArgumentException(INPUT_WRONG_DIRECTION.getMessage());
        }
    }),
    ;

    private final Validator<String> validator;

    MoveDirectionValidator(final Validator<String> validator) {
        this.validator = validator;
    }

    public static void validate(final String direction) {
        Arrays.stream(values()).forEach(v -> v.validator.validate(direction));
    }

    private static boolean isNotExistDirection(final String direction) {
        return !Moving.contains(direction);
    }
}
