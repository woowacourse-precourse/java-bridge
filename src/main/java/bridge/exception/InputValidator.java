package bridge.exception;

import bridge.common.Error;

public class InputValidator {
    private static String UP_BRIDGE = "U";
    private static String DOWN_BRIDGE = "D";
    private static String RETRY_GAME = "R";
    private static String END_GAME = "Q";
    private static int MIN_BRIDGE_SIZE = 3;
    private static int MAX_BRIDGE_SIZE = 20;

    public static void inputBridgeSizeValidate(String bridgeSize) {
        checkNumber(bridgeSize);
        checkSizeInRange(bridgeSize);
    }

    public static void inputMovingValidate(String moving) {
        checkCorrectMoving(moving);
    }

    public static void inputGameCommandValidate(String command) {
        checkCorrectCommand(command);
    }

    private static void checkCorrectCommand(String command) {
        if(!(RETRY_GAME.equals(command) || END_GAME.equals(command))) {
            throw new IllegalArgumentException(Error.NOT_RETRY_COMMAND.getMessage());
        }
    }

    private static void checkCorrectMoving(String moving) {
        if(!(UP_BRIDGE.equals(moving) || DOWN_BRIDGE.equals(moving))) {
            throw new IllegalArgumentException(Error.NOT_BRIDGE_COMMAND.getMessage());
        }
    }

    private static void checkNumber(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.NOT_NUMBER.getMessage());
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(Error.NOT_NUMBER.getMessage());
        }
    }

    private static void checkSizeInRange(String bridgeSize) {
        int size = Integer.parseInt(bridgeSize);
        if (size < MIN_BRIDGE_SIZE || MAX_BRIDGE_SIZE < size) {
            throw new IllegalArgumentException(Error.NOT_IN_RANGE.getMessage());
        }
    }
}
