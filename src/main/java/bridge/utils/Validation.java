package bridge.utils;

import static bridge.domain.ErrorMessage.BRIDGE_SIZE_INCORRECT_INPUT;
import static bridge.domain.ErrorMessage.BRIDGE_INCORRECT_SIZE;
import static bridge.domain.ErrorMessage.MOVING_INCORRECT_INPUT;
import static bridge.utils.Constants.UP;
import static bridge.utils.Constants.DOWN;

public class Validation {

    public static void validateBridgeSize(String input) {
        if (hasNonDigitCharacter(input)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_INCORRECT_INPUT.toString());
        }
        if (isOutOfRange(input)) {
            throw new IllegalArgumentException(BRIDGE_INCORRECT_SIZE.toString());
        }
    }

    public static void validateMoving(String input) {
        if (isNotUpOrDown(input)) {
            throw new IllegalArgumentException(MOVING_INCORRECT_INPUT.toString());
        }
    }

    private static boolean hasNonDigitCharacter(String input) {
        return !input.chars().allMatch(Character::isDigit);
    }

    private static boolean isOutOfRange(String input) {
        int bridgeSize = Integer.parseInt(input);
        return bridgeSize > 20 || bridgeSize < 3;
    }

    private static boolean isNotUpOrDown(String input) {
        return !input.equals(UP) && !input.equals(DOWN);
    }
}
