package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final int BRIDGE_MAXIMUM_SIZE = 20;
    private static final int BRIDGE_MINIMUM_SIZE = 3;
    private static final String BRIDGE_UPPER_DIRECTION = "U";
    private static final String BRIDGE_DOWN_DIRECTION = "D";
    private static final String GAME_RESTART_KEY = "R";
    private static final String GAME_QUIT_KEY = "Q";


    public static int inputBridgeSize() {
        String bridgeSize = Console.readLine().trim();
        validateSizeNumber(bridgeSize);
        validateSizeRange(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    private static void validateSizeNumber(String bridgeSize) {
        if (!bridgeSize.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(OutputMessage.ERROR_BRIDGE_SIZE.getErrorMessage());
        }
    }

    private static void validateSizeRange(String bridgeSize) {
        if (Integer.parseInt(bridgeSize) < BRIDGE_MINIMUM_SIZE ||
            Integer.parseInt(bridgeSize) > BRIDGE_MAXIMUM_SIZE) {
            throw new IllegalArgumentException(OutputMessage.ERROR_SIZE_RANGE.getErrorMessage());
        }
    }

    public static String inputBridgeMove() {
        String bridgeDirection = Console.readLine().trim();
        validateMoveCell(bridgeDirection);
        return bridgeDirection;
    }

    private static void validateMoveCell(String bridgeDirection) {
        if (!bridgeDirection.equals(BRIDGE_UPPER_DIRECTION)
            && !bridgeDirection.equals(BRIDGE_DOWN_DIRECTION)) {
            throw new IllegalArgumentException(OutputMessage.ERROR_MOVING.getErrorMessage());
        }
    }

    public static String inputGameReStart() {
        String bridgeDirection = Console.readLine().trim();
        validateGameRestart(bridgeDirection);
        return bridgeDirection;
    }

    private static void validateGameRestart(String bridgeDirection) {
        if (!bridgeDirection.equals(GAME_RESTART_KEY)
            && !bridgeDirection.equals(GAME_QUIT_KEY)) {
            throw new IllegalArgumentException(OutputMessage.ERROR_RESTART.getErrorMessage());
        }
    }
}
