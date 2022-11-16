package bridge.Utils.Validation;

import bridge.Utils.ExceptionType;

public class Validation {

    private final int BRIDGE_MIN_SIZE = 3;
    private final int BRIDGE_MAX_SIZE = 20;

    ValidationForOnlyOneUpperAlpha onlyOneUpperAlpha;

    public static void validateIsNumber(String target) {
        String numberRegex = "^[0-9]*$";
        if (!target.matches(numberRegex)) {
            throw new IllegalArgumentException(ExceptionType.IS_NOT_NUMBER.getMessage());
        }
    }

    public void isBridgeSize(int target) {
        if (target < BRIDGE_MIN_SIZE) {
            throw new IllegalArgumentException(ExceptionType.IS_LOWER_THAN_MIN_BRIDGE_SIZE.getMessage());
        }
        if (target > BRIDGE_MAX_SIZE) {
            throw new IllegalArgumentException(ExceptionType.IS_HIGHER_THAN_MAX_BRIDGE_SIZE.getMessage());
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
            throw new IllegalArgumentException(ExceptionType.IS_NOT_MOVING_ALPHABET.getMessage());
        }
    }

    private void isGameCommandAlphabet(String target) {
        String gameCommandAlphabetRegx = "^[RQ]$";
        if (!target.matches(gameCommandAlphabetRegx)) {
            throw new IllegalArgumentException(ExceptionType.IS_NOT_GAME_COMMAND_ALPHABET.getMessage());
        }
    }
}
