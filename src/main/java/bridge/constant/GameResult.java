package bridge.constant;

public enum GameResult {

    SUCCESS("| O ]", "성공"),
    FAILURE("| X ]", "실패");

    private final String nowCondition;
    private final String gameResult;

    GameResult(String nowCondition, String gameResult) {
        this.nowCondition = nowCondition;
        this.gameResult = gameResult;
    }

    public String getNowCondition() {
        return nowCondition;
    }

    public String getGameResult() {
        return gameResult;
    }
}
