package bridge.gameplay;

public enum GameState {
    MOVABLE,
    FAIL_TO_MOVE,
    GAME_END;

    public static final String RETRY_COMMAND = "R";
    public static final String QUIT_COMMAND = "Q";
}