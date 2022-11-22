package bridge.validation;

import static bridge.validation.util.ValidationUtil.isInteger;
import static bridge.validation.util.ValidationUtil.isOneCharacter;
import static bridge.validation.util.ValidationUtil.isValidGameCommand;
import static bridge.validation.util.ValidationUtil.isValidMoving;
import static bridge.validation.util.ValidationUtil.isWithinValidRange;

public class Validator {

    public static void validateBridgeSize(String bridgeSize) {
        if (!isInteger(bridgeSize)) {
            throw new IllegalArgumentException();
        }

        if (!isWithinValidRange(bridgeSize)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateMoving(String moving) {
        if (!isOneCharacter(moving)) {
            throw new IllegalArgumentException();
        }

        if (!isValidMoving(moving)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateGameCommand(String gameCommand) {
        if (!isOneCharacter(gameCommand)) {
            throw new IllegalArgumentException();
        }

        if (!isValidGameCommand(gameCommand)) {
            throw new IllegalArgumentException();
        }
    }
}
