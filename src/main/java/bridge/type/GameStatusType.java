package bridge.type;

public enum GameStatusType {
    PLAYING("진행"),
    END("성공"),
    FAIL("실패");

    private final String gameStatus;

    GameStatusType(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    public String toString() {
        return gameStatus;
    }
}
