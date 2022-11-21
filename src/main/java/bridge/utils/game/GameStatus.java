package bridge.utils.game;

public enum GameStatus {
    APPLICATION_START,
    MAKE_BRIDGE,
    GAME_PLAY,
    GAME_OVER,
    GAME_EXIT,
    APPLICATION_EXIT;

    public static GameStatus findNextGamePlay(boolean success, boolean movable) {
        if (success) {
            return GameStatus.GAME_EXIT;
        }
        if (movable) {
            return GameStatus.GAME_PLAY;
        }
        return GameStatus.GAME_OVER;
    }

    public boolean playable() {
        if (this != GameStatus.APPLICATION_EXIT) {
            return true;
        }
        return false;
    }
}
