package bridge.exception;

public class IllegalArgument {

    public static boolean isNotNumber(String numberInput) {
        if (numberInput.matches("[0-9]+")) {
            return false;
        }
        return true;
    }

    public static boolean isNotInBridgeSizeRange(String bridgeSizeInput) {
        if (Integer.parseInt(bridgeSizeInput) <3 || Integer.parseInt(bridgeSizeInput) > 20) {
            return true;
        }
        return false;
    }
}
