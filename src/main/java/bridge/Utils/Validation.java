package bridge.Utils;

public class Validation {

    private final int BRIDGE_MIN_SIZE = 3;
    private final int BRIDGE_MAX_SIZE = 20;

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
        isOnlyAlphabets(target);
        isOneAlphabet(target);
        isLowerAlphabet(target);
        isMovingAlphabet(target);
    }

    private void isOnlyAlphabets(String target) {
        String alphabetsRegex = "^[a-zA-Z]*$";
        if (!target.matches(alphabetsRegex)) {
            throw new IllegalArgumentException(ExceptionType.IS_NOT_ONLY_ALPHABET.getMessage());
        }
    }

    private void isOneAlphabet(String target) {
        String oneAlphabetRegex = "^[a-zA-Z]$";
        if (!target.matches(oneAlphabetRegex)) {
            throw new IllegalArgumentException(ExceptionType.IS_NOT_ONE_ALPHABET.getMessage());
        }
    }

    private void isLowerAlphabet(String target) {
        String lowerAlphabetRegex = "^[a-z]$";
        if (!target.matches(lowerAlphabetRegex)) {
            throw new IllegalArgumentException(ExceptionType.IS_NOT_UPPER_ALPHABET.getMessage());
        }
    }

    private void isMovingAlphabet(String target) {
        String movingAlphabetRegex = "^[UD]$";
        if (!target.matches(movingAlphabetRegex)) {
            throw new IllegalArgumentException(ExceptionType.IS_NOT_MOVING_ALPHABET.getMessage());
        }
    }
}
