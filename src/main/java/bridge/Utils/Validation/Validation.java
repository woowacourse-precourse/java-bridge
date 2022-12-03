package bridge.Utils.Validation;

import bridge.Utils.ExceptionType;

public class Validation {

    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;

    ValidationForOneUpperAlphabet onlyOneUpperAlpha;

    public Validation() {
        onlyOneUpperAlpha = new ValidationForOneUpperAlphabet();
    }

    public static void validateIsNumber(String target) {
        String numberRegex = "^[0-9]*$";
        if (!target.matches(numberRegex)) {
            throw new IllegalArgumentException(ExceptionType.NOT_NUMBER.getMessage());
        }
    }

    public void isBridgeSize(int target) {
        if (target < BRIDGE_MIN_SIZE) {
            throw new IllegalArgumentException(ExceptionType.LOWER_THAN_MIN_BRIDGE_SIZE.getMessage());
        }
        if (target > BRIDGE_MAX_SIZE) {
            throw new IllegalArgumentException(ExceptionType.HIGHER_THAN_MAX_BRIDGE_SIZE.getMessage());
        }
    }

    public void isRightMoving(String target) {
        onlyOneUpperAlpha.check(target);
        isMovingAlphabet(target);
    }

    public void isGameCommand(String target) {
        onlyOneUpperAlpha.check(target);
        isGameCommandAlphabet(target);
    }

    private void isMovingAlphabet(String target) {
        String movingAlphabetRegex = "^[UD]$";
        if (!target.matches(movingAlphabetRegex)) {
            throw new IllegalArgumentException(ExceptionType.NOT_MOVING_ALPHABET.getMessage());
        }
    }

    private void isGameCommandAlphabet(String target) {
        String gameCommandAlphabetRegx = "^[RQ]$";
        if (!target.matches(gameCommandAlphabetRegx)) {
            throw new IllegalArgumentException(ExceptionType.NOT_GAME_COMMAND_ALPHABET.getMessage());
        }
    }
}
