package bridge.exceptions;

public class InputException {
    public static int bridgeSizeInputError(String bridgeSizeInput) throws IllegalArgumentException{
        bridgeSizeNumberError(bridgeSizeInput);
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        bridgeSizeRangeError(bridgeSize);
        return bridgeSize;
    }

    public static void bridgeSizeNumberError(String bridgeSizeInput) {
        for (int i = 0; i < bridgeSizeInput.length(); i++) {
            if (!Character.isDigit(bridgeSizeInput.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void bridgeSizeRangeError(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException();
        }
    }

    public static void movingInputError(String movingInput) {
        if (!movingInput.equals("U") && !movingInput.equals("D")) {
            throw new IllegalArgumentException();
        }
    }

    public static void gameCommandInputError(String gameCommandInput) {
        if (!gameCommandInput.equals("R") && !gameCommandInput.equals("Q")) {
            throw new IllegalArgumentException();
        }
    }
}
