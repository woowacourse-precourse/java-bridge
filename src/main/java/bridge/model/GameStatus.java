package bridge.model;

import bridge.model.command.GameCommand;

public enum GameStatus {

    SETTING_GAME,
    CREATING_BRIDGE,
    INITIALIZING_GAME_VARIABLE,
    START_GAME,
    ROUND_SUCCESS,
    ROUND_FAIL,
    RECEIVE_GAME_COMMAND,
    GAME_SUCCESS,
    GAME_FAIL,
    RETRY_GAME,
    QUIT_GAME,
    PRINT_RESULT;

    public static GameStatus fromRoundStatus(RoundStatus roundStatus) {
        if (roundStatus == RoundStatus.ROUND_SUCCESS) {
            return ROUND_SUCCESS;
        }
        return ROUND_FAIL;
    }

    public static GameStatus fromGameCommand(GameCommand gameCommand) {
        if(gameCommand == GameCommand.RETRY) {
            return RETRY_GAME;
        }
        return QUIT_GAME;
    }

    public boolean isContinueGame() {
        return this == RETRY_GAME;
    }

    public boolean isContinueRounds() {
        return this != GAME_SUCCESS && this != ROUND_FAIL;
    }

}
