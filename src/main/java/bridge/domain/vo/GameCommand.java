package bridge.domain.vo;

import static bridge.enumeration.Command.QUIT;
import static bridge.enumeration.Command.RETRY;
import static bridge.enumeration.ErrorMessage.INVALID_RETRY_COMMAND;
import static bridge.enumeration.ErrorMessage.NOT_CHARACTER;

public class GameCommand {

    private final String gameCommand;
    private final int GAME_COMMAND_MAX_LENGTH = 1;

    public static GameCommand determineRetry(String gameCommand) {
        return new GameCommand(gameCommand);
    }

    private GameCommand(String gameCommand){
        validateGameCommand(gameCommand);
        this.gameCommand = gameCommand;
    }

    public String getGameCommand() {
        return this.gameCommand;
    }

    private void validateGameCommand(String gameCommand) {
        if (gameCommand.length() != GAME_COMMAND_MAX_LENGTH) {
            throw new IllegalArgumentException(NOT_CHARACTER.getMessage());
        }
        if (!gameCommand.equals(RETRY.getCommand()) && !gameCommand.equals(QUIT.getCommand())) {
            throw new IllegalArgumentException(INVALID_RETRY_COMMAND.getMessage());
        }
    }
}
