package bridge.constant;

public enum AfterMovingStatusConstant {

    FAIL( true, false, "실패"),
    NEXT_TURN( false, false, "실패"),
    SUCCESS( true, true, "성공");


    private final boolean isFinishThisTurn;
    private final boolean isGameSuccess;
    private final String gameSuccessMessage;

    AfterMovingStatusConstant(boolean isFinishThisTurn, boolean isGameSuccess, String gameSuccessMessage) {
        this.isFinishThisTurn = isFinishThisTurn;
        this.isGameSuccess = isGameSuccess;
        this.gameSuccessMessage = gameSuccessMessage;
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
