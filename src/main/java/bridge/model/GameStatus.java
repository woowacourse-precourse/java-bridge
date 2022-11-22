package bridge.model;

public enum GameStatus {
    CROSSING("건너는 중", "O"),
    FAIL("실패", "X"),
    SUCCESS("성공", "O"),
    ;

    private final String state;

    private final String safe;

    GameStatus(String state, String safe) {
        this.state = state;
        this.safe = safe;
    }

    public String getSafe() {
        return safe;
    }

    public String getState() {
        return state;
    }
}
