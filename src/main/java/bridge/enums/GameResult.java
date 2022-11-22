package bridge.enums;

/**
 * 게임의 결과를 나타낸다.
 */
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
