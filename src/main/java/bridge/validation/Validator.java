package bridge.validation;

import static bridge.validation.util.ValidationUtil.isInteger;
import static bridge.validation.util.ValidationUtil.isOneCharacter;
import static bridge.validation.util.ValidationUtil.isValidGameCommand;
import static bridge.validation.util.ValidationUtil.isValidMoving;
import static bridge.validation.util.ValidationUtil.isWithinValidRange;

import bridge.validation.exception.InvalidGameCommandException;
import bridge.validation.exception.InvalidMovingException;
import bridge.validation.exception.InvalidRangeException;
import bridge.validation.exception.NotIntegerException;
import bridge.validation.exception.NotOneCharacterException;

public class Validator {

    public static void validateBridgeSize(String bridgeSize) {
        if (!isInteger(bridgeSize)) {
            throw new NotIntegerException();
        }

        if (!isWithinValidRange(bridgeSize)) {
            throw new InvalidRangeException();
        }
    }

    public static void validateMoving(String moving) {
        if (!isOneCharacter(moving)) {
            throw new NotOneCharacterException();
        }

        if (!isValidMoving(moving)) {
            throw new InvalidMovingException();
        }
    }

    public static void validateGameCommand(String gameCommand) {
        if (!isOneCharacter(gameCommand)) {
            throw new NotOneCharacterException();
        }

        if (!isValidGameCommand(gameCommand)) {
            throw new InvalidGameCommandException();
        }
    }
}
