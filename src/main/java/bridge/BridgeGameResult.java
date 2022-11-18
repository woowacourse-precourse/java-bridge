package bridge;

/**
 * 다리 건너기 게임의 최종 결과를 관리하는 클래스
 */
public class BridgeGameResult {

    private int tryCount;
    private String gameResult;
    private BridgeMoveResult moveResult;

    public BridgeGameResult() {
        tryCount = 1;
        gameResult = "";
        moveResult = new BridgeMoveResult();
    }
}
