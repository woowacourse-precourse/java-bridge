package bridge;

import bridge.constant.BridgeSize;
import bridge.constant.Message;
import bridge.constant.Token;

public class Validator {
    public static void isIntegerValue(String input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_BRIDGE_SIZE_FORMAT.getMessage());
        }
    }

    public static void isInRangeValue(int value) {
        final int max = BridgeSize.MAX.getValue();
        final int min = BridgeSize.MIN.getValue();
        if (value < min || value > max) {
            throw new IllegalArgumentException(Message.ERROR_BRIDGE_SIZE_RANGE.getMessage());
        }
    }

    public static void isMovingCommand(String input) {
        for (String mark : Token.getMovingMark()) {
            if (input.equals(mark)) {
                return;
            }
        }
        throw new IllegalArgumentException(Message.ERROR_MOVING_COMMAND.getMessage());
    }
}
