package bridge.util;

public class Exceptions {

    public static String validateBridgeLength(String readLine) {
        try {
            if (!readLine.matches("^[0-9]*?") || Integer.parseInt(readLine) < 3 || Integer.parseInt(readLine) > 20) {
                throw new IllegalArgumentException(ConstantMessage.BRIDGE_LENGTH_ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return readLine;
    }

    public static String validateMovingBlock(String readLine) {
        try {
            if (!readLine.equals("U") || !readLine.equals("D")) {
                throw new IllegalArgumentException(ConstantMessage.MOVING_BLOCK_ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return readLine;
    }
}
