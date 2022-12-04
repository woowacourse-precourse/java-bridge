package bridge.model.status;

import bridge.model.command.GameCommand;

public enum GameStatus {

    SETTING_GAME,
    CREATING_BRIDGE,
    INITIALIZING_GAME_VARIABLE,
    START_GAME,
    RECEIVE_GAME_COMMAND,
    GAME_SUCCESS,
    GAME_FAIL,
    RETRY_GAME,
    QUIT_GAME,
    PRINT_RESULT;

    public static GameStatus fromGameCommand(GameCommand gameCommand) {
        if (gameCommand == GameCommand.RETRY) {
            return RETRY_GAME;
        }
        return QUIT_GAME;
    }

    public boolean isExitGame() {
        return this == QUIT_GAME || this == GAME_SUCCESS;
    }

   public boolean isRetryGame() {
        return this == RETRY_GAME;
    }

    public boolean isGameFail() {
        return this == GAME_FAIL;
    }


}
