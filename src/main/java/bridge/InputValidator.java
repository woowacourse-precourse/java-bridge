package bridge;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class InputValidator {

    public static boolean validateBridgeLengthInput(String text) {
        return validateOrThrowIllegalException(text, InputValidator::isValidBridgeLengthInput,
                Messages.INVALID_BRIDGE_LENGTH_ERROR);
    }

    private static boolean validateOrThrowIllegalException(String input, Predicate<String> validator, String message) {
        if (!validator.test(input)) {
            throwIllegalArgumentException(message);
        }
        return true;
    }

    private static void throwIllegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }

    private static boolean isValidBridgeLengthInput(String text) {
        int BRIDGE_LENGTH_LOWER_INCLUSIVE = 3;
        int BRIDGE_LENGTH_UPPER_INCLUSIVE = 20;
        return isNumber(text) && isBetween(Integer.parseInt(text), BRIDGE_LENGTH_LOWER_INCLUSIVE,
                BRIDGE_LENGTH_UPPER_INCLUSIVE);
    }

    private static boolean isNumber(String text) {
        return Pattern.compile("\\d+").matcher(text).matches();
    }

    private static boolean isBetween(int n, int lowerInclusive, int upperInclusive) {
        return n >= lowerInclusive && n <= upperInclusive;
    }

    public static boolean validateBridgeGameMovingInput(String text) {
        return validateOrThrowIllegalException(text, InputValidator::isValidBridgeGameMovingInput,
                Messages.INVALID_MOVING_INPUT_ERROR);
    }

    private static boolean isValidBridgeGameMovingInput(String text) {
        return BridgeGameMovingInput.fromKey(text) != null;
    }

    public static boolean validateBridgeGameCommandInput(String text) {
        return validateOrThrowIllegalException(text, InputValidator::isValidBridgeGameCommandInput,
                Messages.INVALID_GAME_COMMAND_INPUT_ERROR);
    }

    private static boolean isValidBridgeGameCommandInput(String text) {
        return BridgeGameCommandInput.fromKey(text) != null;
    }
}
