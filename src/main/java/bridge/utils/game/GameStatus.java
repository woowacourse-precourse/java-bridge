package bridge.utils.game;

public enum GameStatus {
    APPLICATION_START(true),
    MAKE_BRIDGE(true),
    GAME_PLAY(true),
    GAME_OVER(true),
    GAME_EXIT(true),
    APPLICATION_EXIT(false);

    private final boolean playable;

    GameStatus(boolean playable) {
        this.playable = playable;
    }

    public static GameStatus findNextGamePlay(boolean success, boolean movable) {
        if (success) {
            return GameStatus.GAME_EXIT;
        }
        if (movable) {
            return GameStatus.GAME_PLAY;
        }
        return GameStatus.GAME_OVER;
    }

    public boolean isPlayable() {
        return playable;
    }
}
