package bridge.constant;

public enum AfterMovingStatusConstant {

    FAIL(false, true, false, "실패"),
    NEXT_TURN(true, false, false, "실패"),
    SUCCESS(false, true, true, "성공");

    private final boolean continueThisTurn;
    private final boolean isFinishThisTurn;
    private final boolean isGameSuccess;
    private final String gameSuccessMessage;

    AfterMovingStatusConstant(boolean continueThisTurn, boolean isFinishThisTurn, boolean isGameSuccess, String gameSuccessMessage) {
        this.continueThisTurn = continueThisTurn;
        this.isFinishThisTurn = isFinishThisTurn;
        this.isGameSuccess = isGameSuccess;
        this.gameSuccessMessage = gameSuccessMessage;
    }

    public boolean isContinueThisTurn() {
        return continueThisTurn;
    }

    public boolean isFinishThisTurn() {
        return isFinishThisTurn;
    }

    public boolean isGameSuccess() {
        return isGameSuccess;
    }

    public String getGameSuccessMessage() {
        return gameSuccessMessage;
    }

}
