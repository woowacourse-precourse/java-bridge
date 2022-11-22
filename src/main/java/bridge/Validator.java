package bridge;

import bridge.constant.BridgeSize;
import bridge.constant.Message;
import bridge.constant.Token;

public class Validator {
    public static int validateBridgeSize(String userInput) {
        isIntegerValue(userInput);
        int size = Integer.parseInt(userInput);
        isInRangeValue(size);
        return size;
    }

    public static String validateMoving(String userInput) {
        isMovingCommand(userInput);
        return userInput;
    }

    public static String validateGameCommand(String userInput) {
        isGameCommand(userInput);
        return userInput;
    }

    private static void isIntegerValue(String input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_BRIDGE_SIZE_FORMAT.getMessage());
        }
    }

    private static void isInRangeValue(int value) {
        final int max = BridgeSize.MAX.getValue();
        final int min = BridgeSize.MIN.getValue();
        if (value < min || value > max) {
            throw new IllegalArgumentException(Message.ERROR_BRIDGE_SIZE_RANGE.getMessage());
        }
    }

    private static void isMovingCommand(String input) {
        for (String mark : Token.getMovingMark()) {
            if (input.equals(mark)) {
                return;
            }
        }
        throw new IllegalArgumentException(Message.ERROR_MOVING_COMMAND.getMessage());
    }

    private static void isGameCommand(String input) {
        for (String mark : Token.getRetryMark()) {
            if (input.equals(mark)) {
                return;
            }
        }
        throw new IllegalArgumentException(Message.ERROR_GAME_COMMAND.getMessage());
    }
}
