package bridge.enums;

public enum GameResult {
    SUCCESS("성공"),
    FAIL("실패"),
    ;
    private final String gameResult;

    GameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    @Override
    public String toString() {
        return gameResult;
    }
}
