package bridge.domain;

import bridge.exception.BridgeError;
import bridge.exception.ErrorException;

public class GameCommand {
    private static final String RESTART_GAME = "R";
    private static final String END_GAME = "Q";

    private final String gameCommand;

    public GameCommand(String gameCommand) {
        checkInvalidGameCommand();
        this.gameCommand = gameCommand;
    }

    private void checkInvalidGameCommand() {
        if(gameCommand.equals(RESTART_GAME) || gameCommand.equals(END_GAME)){
            throw new ErrorException(BridgeError.INVALID_GAME_STATUS);
        };
    }
}
