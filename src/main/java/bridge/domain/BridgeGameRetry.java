package bridge.domain;

import static bridge.utils.ErrorMessages.ERROR_INVALID_GAME_COMMAND;

public class BridgeGameRetry {
    private static final String RETRY = "R";
    private static final String END = "Q";

    public boolean retry(String gameCommand) {
        validateGameCommand(gameCommand);
        return isRetry(gameCommand);
    }

    private boolean isRetry(String gameCommand) {
        return gameCommand.equals(RETRY);
    }

    private void validateGameCommand(String gameCommand) {
        if (!isGameCommand(gameCommand)) {
            throw new IllegalArgumentException(ERROR_INVALID_GAME_COMMAND);
        }
    }

    private boolean isGameCommand(String gameCommand) {
        return gameCommand.equals(RETRY) || gameCommand.equals(END);
    }
}
