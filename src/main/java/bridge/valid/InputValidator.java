package bridge.valid;

import bridge.exception.BridgeGameError;

import java.util.regex.Pattern;

public class InputValidator {
    public static final String ONLY_NUMBER = "^[0-9]*$";

    private InputValidator() {
    }

    public static void validateType(String size) {
        if (!isNumber(size)) {
            throw new IllegalArgumentException(BridgeGameError.BRIDGE_SIZE_NOT_NUMBER.getErrorMessage());
        }
    }

    private static boolean isNumber(String size) {
        return Pattern.matches(ONLY_NUMBER, size);
    }
}
