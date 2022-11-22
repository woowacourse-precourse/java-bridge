package bridge.game;

public enum GameState {

    GAME_ON_STATE(0),
    GAME_OVER_STATE(1),
    GAME_CLEAR_STATE(2);

    public final int value;

    GameState(int value) {
        this.value = value;
    }
}
