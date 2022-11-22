package bridge.constant;

public enum GameState {
    PROCEEDING_SUCCESS("진행중", "성공"), PROCEEDING_FAIL("진행중", "실패"), END_SUCCESS("종료",
        "성공"), END_FAIL("종료", "실패");

    private final String status;
    private final String result;

    GameState(String status, String result) {
        this.status = status;
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }

    public boolean isEnd() {
        return this.status.equals("종료");
    }

    public boolean isNotFail() {
        return this.result.equals("성공");
    }

    public static GameState toEnd(GameState gameState) {
        if (gameState.result.equals("성공")) {
            return END_SUCCESS;
        }
        return END_FAIL;
    }
}
