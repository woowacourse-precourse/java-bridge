package bridge.model.status;

import bridge.model.command.GameCommand;

public enum GameStatus {

    START_GAME,
    GAME_SUCCESS,
    GAME_FAIL,
    RETRY_GAME,
    QUIT_GAME;

    public static GameStatus fromGameCommand(GameCommand gameCommand) {
        if (gameCommand.equals(GameCommand.RETRY)) {
            return RETRY_GAME;
        }
        return QUIT_GAME;
    }

    public boolean isExitGame() {
        return this.equals(QUIT_GAME) || this.equals(GAME_SUCCESS);
    }

    public boolean isRetryGame() {
        return this.equals(RETRY_GAME);
    }

    public boolean isGameFail() {
        return this.equals(GAME_FAIL);
    }

    public boolean isGameSuccess() {
        return this.equals(GAME_SUCCESS);
    }
}
