package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeGameResult bridgeGameResult;

    public BridgeGame() {
        bridgeGameResult = new BridgeGameResult();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     * @param bridge 다리
     * @param play   이동 횟수
     * @param moving 이동할 칸
     * @return
     */
    public String move(Bridge bridge, int play, String moving) {
        boolean mobility = bridge.isPossibleMoving(play, moving);
        bridgeGameResult.makeMoveResult(moving, mobility);
        return " ";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     * @param gameResult 다리 건너기 게임 결과
     */
    public void retry(BridgeGameResult gameResult) {
        gameResult.increaseTryCount();
        gameResult.initMoveResult();
    }
}
