package bridge.utils.validator;

import static bridge.utils.constants.ErrorConstants.NOT_MATCH_MOVING_OPTION;
import static bridge.utils.constants.ErrorConstants.NOT_MATCH_GAME_COMMAND;

public class GameValidator {

    public static void validMovingOption(String movingOption) {
        if (!movingOption.equals("U") || !movingOption.equals("D")) {
            throw new IllegalArgumentException(NOT_MATCH_MOVING_OPTION);
        }
    }

    public static void validGameCommand(String gameCommand) {
        if (!gameCommand.equals("R") || !gameCommand.equals("Q")) {
            throw new IllegalArgumentException(NOT_MATCH_GAME_COMMAND);
        }
    }
}
