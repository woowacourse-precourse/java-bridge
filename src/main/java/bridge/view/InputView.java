package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final int BRIDGE_MAXIMUM_SIZE = 20;
    private static final int BRIDGE_MINIMUM_SIZE = 3;
    private static final List<String> BRIDGE_DIRECTION = new ArrayList<>(List.of("U", "D"));
    private static final List<String> GAME_RESTART_KEY = new ArrayList<>(List.of("R", "Q"));

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
        if (!BRIDGE_DIRECTION.contains(bridgeDirection)) {
            throw new IllegalArgumentException(OutputMessage.ERROR_MOVING.getErrorMessage());
        }
    }

    public static String inputGameReStart() {
        String gameRestart = Console.readLine().trim();
        validateGameRestart(gameRestart);
        return gameRestart;
    }

    private static void validateGameRestart(String gameRestart) {
        if (!GAME_RESTART_KEY.contains(gameRestart)) {
            throw new IllegalArgumentException(OutputMessage.ERROR_RESTART.getErrorMessage());
        }
    }
}
