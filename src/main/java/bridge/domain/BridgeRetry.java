package bridge.domain;

import java.util.Objects;

import static bridge.utils.ErrorMessages.ERROR_INVALID_GAME_COMMAND;

public class BridgeRetry {
    private static final String RETRY = "R";
    private static final String END = "Q";

    public boolean retry(String gameCommand) {

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
