package bridge.util;

public class Exceptions {
    public Exceptions() {
        super();
    }

    public String validateBridgeLength(String readLine) {
        try {
            if (!readLine.matches("^[0-9]*?") || Integer.parseInt(readLine) < 3 || Integer.parseInt(readLine) > 20) {
                throw new IllegalArgumentException(ConstantMessage.BRIDGE_LENGTH_ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return readLine;
    }

    public String validateMovingBlock(String readLine) {
        try {
            if (!readLine.equals("U") && !readLine.equals("D")) {
                throw new IllegalArgumentException(ConstantMessage.MOVING_BLOCK_ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return readLine;
    }

    public String validateRestartGame(String readLine) {
        try {
            if (!readLine.equals("R") && !readLine.equals("Q")) {
                throw new IllegalArgumentException(ConstantMessage.RESTART_GAME_ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return readLine;
    }
}
