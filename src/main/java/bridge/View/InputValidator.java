package bridge.View;

import static bridge.Enum.Error.*;
import static bridge.Enum.Regex.*;

public class InputValidator {
    public static void validateBridgeSize(String bridgeSizeInput) {
        validateBridgeSizeFormat(bridgeSizeInput);
        validateBridgeSizeRange(bridgeSizeInput);
    }

    private static void validateBridgeSizeRange(String bridgeSizeInput) {
        final int MINIMAL_BRIDGE_SIZE = 3;
        final int MAXIMAL_BRIDGE_SIZE = 20;

        int bridgeSize = Integer.parseInt(bridgeSizeInput);

        if (bridgeSize < MINIMAL_BRIDGE_SIZE || bridgeSize > MAXIMAL_BRIDGE_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_RANGE_ERROR.getMessage());
        }
    }

    private static void validateBridgeSizeFormat(String bridgeSizeInput) {
        if(!bridgeSizeInput.matches(BRIDGE_SIZE_ONLY_NUMBER.getRegex())){
            throw new IllegalArgumentException(BRIDGE_SIZE_FORMAT_ERROR.getMessage());
        }
    }

    public static void validateMovingDirection(String movingDirection) {
        if(!movingDirection.matches(MOVING_DIRECTION_ONLY_UD.getRegex())){
            throw new IllegalArgumentException(MOVING_DIRECTION_ERROR.getMessage());
        }
    }

    public static void validateGameCommand(String gameCommand) {
        if (!gameCommand.matches(GAME_COMMAND_ONLY_RQ.getRegex())) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR.getMessage());
        }
    }
}
