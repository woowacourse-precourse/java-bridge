package bridge;

/**
 * 다리 건너기 게임의 최종 결과를 관리하는 클래스
 */
public class BridgeGameResult {

    private static final int FIRST_COUNT = 1;
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    private int tryCount;
    private String gameResult;
    private BridgeMoveResult moveResult;

    public BridgeGameResult() {
        tryCount = FIRST_COUNT;
        gameResult = FAIL;
        moveResult = new BridgeMoveResult();
    }

    public int increaseTryCount() {
        tryCount++;
        return tryCount;
    }

    public void initMoveResult() {
        moveResult = new BridgeMoveResult();
    }

    public void makeMoveResult(String moving, String moveState) {
        moveResult.createResult(moving, moveState);
    }

    public void setSuccess() {
        gameResult = SUCCESS;
    }
}
