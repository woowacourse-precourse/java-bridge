package bridge.utils.validator;

import static bridge.utils.constants.BridgeConstants.UP_CROSS;
import static bridge.utils.constants.BridgeConstants.DOWN_CROSS;
import static bridge.utils.constants.ErrorConstants.NOT_MATCH_MOVING_OPTION;
import static bridge.utils.constants.ErrorConstants.NOT_MATCH_GAME_COMMAND;
import static bridge.utils.constants.GameConstants.RETRY_GAME;
import static bridge.utils.constants.GameConstants.EXIT_GAME;

public class GameValidator {

    public static void validMovingOption(String movingOption) {
        if (!movingOption.equals(UP_CROSS) || !movingOption.equals(DOWN_CROSS)) {
            throw new IllegalArgumentException(NOT_MATCH_MOVING_OPTION);
        }
    }

    public static void validGameCommand(String gameCommand) {
        if (!gameCommand.equals(RETRY_GAME) || !gameCommand.equals(EXIT_GAME)) {
            throw new IllegalArgumentException(NOT_MATCH_GAME_COMMAND);
        }
    }
}
