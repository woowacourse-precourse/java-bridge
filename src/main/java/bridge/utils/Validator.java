package bridge.utils;

public class Validator {

    public static void checkValueOfReadBridgeSize(Integer value) {
        if (isNumeric(value))
            throw new IllegalArgumentException(ErrorMsgs.ERROR_BRIDGE_SIZE_NOT_INT);
        if (value < 3 || value > 20)
            throw new IllegalArgumentException(ErrorMsgs.ERROR_BRIDGE_SIZE_LOW);
    }

    public static boolean isNumeric(Integer s) {
        String value = Integer.toString(s);
        return value == null || !value.matches("[-+]?\\d*\\.?\\d+");
    }

    public static void checkValueOfReadBridgeMove(String value) {
        if (!value.equals("U") && !value.equals("D"))
            throw new IllegalArgumentException(ErrorMsgs.ERROR_BRIDGE_MOVE_TYPE);
    }

    public static void checkValueOfReadGameCommand(String value) {
        if (!value.equals("R") && !value.equals("Q"))
            throw new IllegalArgumentException(ErrorMsgs.ERROR_COMMAND_TYPE);
    }
}
