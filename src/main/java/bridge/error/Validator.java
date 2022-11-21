package bridge.error;

import java.util.Objects;

public class Validator {

    public static int validateLengthOfBridge(String lengthOfBridge) {
        validateIsDigit(lengthOfBridge);
        return validateRangeOfLength(lengthOfBridge);
    }

    private static void validateIsDigit(String number) {
        if (!number.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ERROR_MESSAGE.NOT_INTEGER_BRIDGE_SIZE.getMessage());
        }
    }

    private static int validateRangeOfLength(String number) {
        int lengthOfBridge = Integer.parseInt(number);
        if (lengthOfBridge > 20 || lengthOfBridge < 3) {
            throw new IllegalArgumentException(ERROR_MESSAGE.NOT_RANGE_OF_BRIDGE_SIZE.getMessage());
        }
        return lengthOfBridge;
    }

    public static String validateMoving(String move) {
        if (!(Objects.equals(move, "U") || Objects.equals(move, "D"))) {
            throw new IllegalArgumentException(ERROR_MESSAGE.NOT_TYPE_OF_MOVING.getMessage());
        }
        return move;
    }

    public static String validateGameCommand(String gameCommand) {
        if (!(Objects.equals(gameCommand, "R") || Objects.equals(gameCommand, "Q"))) {
            throw new IllegalArgumentException(ERROR_MESSAGE.NOT_TYPE_OF_GAME_COMMAND.getMessage());
        }
        return gameCommand;
    }


}
