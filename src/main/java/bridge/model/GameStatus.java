package bridge.model;

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
    RESTART_GAME,
    QUIT_GAME,
    PRINT_RESULT;

    public static GameStatus findGameStatus(RoundStatus roundStatus) {
        if (roundStatus == RoundStatus.ROUND_SUCCESS) {
            return ROUND_SUCCESS;
        }
        return ROUND_FAIL;
    }

    public boolean isContinueGame() {
        return this != ROUND_FAIL && this != GAME_SUCCESS;
    }
}
