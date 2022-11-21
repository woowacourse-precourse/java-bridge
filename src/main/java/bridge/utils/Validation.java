package bridge.utils;

import static bridge.domain.ErrorMessage.BRIDGE_SIZE_INCORRECT_INPUT;
import static bridge.domain.ErrorMessage.BRIDGE_INCORRECT_SIZE;

public class Validation {

    public static void validateBridgeSize(String input) {
        if (hasNonDigitCharacter(input)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_INCORRECT_INPUT.toString());
        }
        if (isOutOfRange(input)) {
            throw new IllegalArgumentException(BRIDGE_INCORRECT_SIZE.toString());
        }
    }

    private static boolean hasNonDigitCharacter(String input) {
        return !input.chars().allMatch(Character::isDigit);
    }

    private static boolean isOutOfRange(String input) {
        int bridgeSize = Integer.parseInt(input);
        return bridgeSize > 20 || bridgeSize < 3;
    }
}
