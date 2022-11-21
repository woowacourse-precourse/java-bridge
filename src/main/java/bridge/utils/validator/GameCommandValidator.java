package bridge.utils.validator;

import static bridge.utils.ErrorMessages.ERROR_INVALID_GAME_COMMAND;

public class GameCommandValidator {
    private static final String RETRY = "R";
    private static final String END = "Q";

    private GameCommandValidator() {
    }

    public static void validate(String gameCommand) {
        validateGameCommand(gameCommand);
    }

    private static void validateGameCommand(String gameCommand) {
        if (!isGameCommand(gameCommand)) {
            throw new IllegalArgumentException(ERROR_INVALID_GAME_COMMAND);
        }
    }

    private static boolean isGameCommand(String gameCommand) {
        return gameCommand.equals(RETRY) || gameCommand.equals(END);
    }
}
