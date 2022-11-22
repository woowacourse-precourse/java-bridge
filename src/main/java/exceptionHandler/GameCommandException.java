package exceptionHandler;

import enumCollections.AvailableInput;
import enumCollections.ExceptionMessage;

public class GameCommandException extends InputException {
    public static void validate(String gameCommand) {
        validateCommonException(gameCommand);
        validateGameCommand(gameCommand);
    }

    private static void validateGameCommand(String gameCommand) {
        if (!AvailableInput.isGameCommand(gameCommand)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_GAME_COMMAND.getMessage());
        }
    }
}
