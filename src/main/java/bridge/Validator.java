package bridge;

public class Validator {
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String UP_POSITION_COMMAND = "U";
    private static final String DOWN_POSITION_COMMAND = "D";

    public static void validateBridgeSize(String userInput) {
        try {
            int bridgeSize = Integer.parseInt(userInput);
            if (bridgeSize > MAX_BRIDGE_SIZE || bridgeSize < MIN_BRIDGE_SIZE) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateMoveCommand(String userInput) {
        if (!userInput.equals(UP_POSITION_COMMAND) && !userInput.equals(DOWN_POSITION_COMMAND)) {
            throw new IllegalArgumentException();
        }
    }
}
