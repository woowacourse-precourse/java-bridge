package bridge;

import bridge.constant.Message;

public class Validator {
    public static void isIntegerValue(String input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_BRIDGE_SIZE_FORMAT.getMessage());
        }
    }
}
