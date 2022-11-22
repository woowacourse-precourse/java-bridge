package bridge.domain.bridgeGame.gameStatus.gameStatics;

public enum GameResult {
    NOT_EXIST(true, "결과 없음"),
    FAIL(false, "실패"),
    SUCCESS(true, "성공");

    private final boolean crossSuccess;
    private final String result;

    GameResult(boolean crossSuccess, String result) {
        this.crossSuccess = crossSuccess;
        this.result = result;
    }

    public static GameResult get(boolean crossSuccess) {
        if (crossSuccess) {
            return SUCCESS;
        }
        return FAIL;
    }

    public boolean crossSuccess() {
        return crossSuccess;
    }

    @Override
    public String toString() {
        return result;
    }
}
