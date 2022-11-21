package bridge.constant;

public enum AfterMovingStatusConstant {

    FAIL(false, true, false),
    NEXT_TURN(true, false, false),
    SUCCESS(false, true, true);

    private final boolean continueThisTurn;
    private final boolean isFinishThisTurn;
    private final boolean isGameSuccess;

    AfterMovingStatusConstant(boolean continueThisTurn, boolean isFinishThisTurn, boolean isGameSuccess) {
        this.continueThisTurn = continueThisTurn;
        this.isFinishThisTurn = isFinishThisTurn;
        this.isGameSuccess = isGameSuccess;
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

}
