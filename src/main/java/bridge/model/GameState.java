package bridge.model;

public enum GameState {
    FINISH_SUCCESS(0,true, true),
    FINISH_FAIL(1,true, false),
    NOT_FINISH(2,false, false);

    GameState(int state, boolean finish, boolean success) {
    }
}
