package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGameResult;

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
     * @return 이동 가능성
     */
    public Boolean move(Bridge bridge, int play, String moving) {
        boolean mobility = bridge.isPossibleMoving(play, moving);
        bridgeGameResult.addMoveState(moving, mobility);
        return mobility;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
        bridgeGameResult.increaseTryCount();
        bridgeGameResult.initMoveState();
    }
}
