package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final int BRIDGE_MAXIMUM_SIZE = 20;
    private static final int BRIDGE_MINIMUM_SIZE = 3;
    private static final String BRIDGE_UPPER_DIRECTION = "U";
    private static final String BRIDGE_DOWN_DIRECTION = "D";

    public static int inputBridgeSize() {
        String bridgeSize = Console.readLine().trim();
        validateSizeNumber(bridgeSize);
        validateSizeRange(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    private static void validateSizeNumber(String bridgeSize) {
        if (!bridgeSize.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(OutputMessage.BRIDGE_IS_NUMBER.getErrorMessage());
        }
    }

    private static void validateSizeRange(String bridgeSize) {
        if (Integer.parseInt(bridgeSize) < BRIDGE_MINIMUM_SIZE ||
            Integer.parseInt(bridgeSize) > BRIDGE_MAXIMUM_SIZE) {
            throw new IllegalArgumentException(OutputMessage.BRIDGE_HAS_RANGE.getErrorMessage());
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
            throw new IllegalArgumentException(OutputMessage.MOVING_IS_U_OR_D.getErrorMessage());
        }
    }
}
