package bridge.domain.utils;

public enum GameState {
    START("S"),
    END("Q"),
    RETRY("R"),
    FAILED("X");

    private final String state;

    GameState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
