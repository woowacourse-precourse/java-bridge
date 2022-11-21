package bridge.util.validator;

import java.util.Arrays;

import static bridge.exception.ExceptionType.BRIDGE_SIZE_OUT_OF_RANGE;
import static bridge.service.BridgeMaker.LOWER_BRIDGE_LENGTH;
import static bridge.service.BridgeMaker.UPPER_BRIDGE_LENGTH;

public enum BridgeSizeValidator {
    OUT_OF_RANGE((Integer size) -> {
        if (isBridgeSizeOutOfRange(size)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_OUT_OF_RANGE.getMessage());
        }
    }),
    ;

    private final Validator<Integer> validator;

    BridgeSizeValidator(final Validator<Integer> validator) {
        this.validator = validator;
    }

    public static void validate(final Integer size) {
        Arrays.stream(values()).forEach(v -> v.validator.validate(size));
    }

    public static boolean isBridgeSizeOutOfRange(final int size) {
        return size < LOWER_BRIDGE_LENGTH || size > UPPER_BRIDGE_LENGTH;
    }
}
