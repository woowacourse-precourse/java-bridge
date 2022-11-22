package bridge.domain;

import bridge.exception.BridgeError;
import bridge.exception.ErrorException;
import bridge.utils.Constants;

public class GameCommand {
    private final String gameCommand;

    public GameCommand(String gameCommand) {
        this.gameCommand = gameCommand;
        checkInvalidGameCommand();
    }

    private void checkInvalidGameCommand() {
        if (!gameCommand.equals(Constants.RESTART_GAME) && !gameCommand.equals(Constants.END_GAME)) {
            throw new ErrorException(BridgeError.INVALID_GAME_STATUS);
        }
    }
}
