package bridge;

public class Validator {

    public static void validateNumber(String userInput) {
        for (int index = 0; index < userInput.length(); index++) {
            if (!Character.isDigit(userInput.charAt(index))) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_ERROR.getMessage());
            }
        }
    }

    public static void validateRange(int bridgeNumber) {
        if (bridgeNumber < 3 || bridgeNumber > 20) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getMessage());
        }
    }

    public static void validateLength(String userInput) {
        if (userInput.length() != 1) {
            throw new IllegalArgumentException(ErrorMessage.LENGTH_ERROR.getMessage());
        }
    }

    public static void validateMoving(String moving) {
        if (moving.charAt(0) != 'U' && moving.charAt(0) != 'D') {
            throw new IllegalArgumentException(ErrorMessage.MOVING_ERROR.getMessage());
        }
    }

    public static void validateGameCommand(char gameCommand) {
        if (gameCommand != 'R' && gameCommand != 'Q') {
            throw new IllegalArgumentException(ErrorMessage.GAMECOMMAND_ERROR.getMessage());
        }
    }
}
