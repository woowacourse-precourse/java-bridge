package bridge.domain;

public class BridgeGameResult {

    private static final int FIRST_COUNT = 1;
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    private int tryCount;
    private String gameResult;
    private BridgeMoveState moveState;

    public BridgeGameResult() {
        tryCount = FIRST_COUNT;
        gameResult = FAIL;
        moveState = new BridgeMoveState();
    }

    public int increaseTryCount() {
        return ++tryCount;
    }

    public void initMoveState() {
        moveState = new BridgeMoveState();
    }

    public void updateMoveState(String moving, Boolean canMove) {
        moveState.update(moving, canMove);
    }

    public void setSuccess() {
        gameResult = SUCCESS;
    }

    public int getTryCount() {
        return tryCount;
    }

    public String getGameResult() {
        return gameResult;
    }

    public BridgeMoveState getMoveState() {
        return moveState;
    }
}
