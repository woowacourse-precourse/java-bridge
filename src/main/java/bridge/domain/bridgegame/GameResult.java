package bridge.domain.bridgegame;

public enum GameResult {
    FAIL("실패"),
    SUCCESS("성공");

    private final String result;

    GameResult(String result) {
        this.result = result;
    }

    public static String toString(boolean gameClear) {
        if (gameClear) {
            return SUCCESS.result;
        }
        return FAIL.result;
    }
}
