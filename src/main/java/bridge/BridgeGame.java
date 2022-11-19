package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGameResult;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final BridgeGameResult bridgeGameResult;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.bridgeGameResult = new BridgeGameResult();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     * @param moveCount 이동 횟수
     * @param moving    이동할 칸
     * @return 이동 가능여부
     */
    public boolean move(int moveCount, String moving) {
        boolean canMove = bridge.canMove(moveCount, moving);
        bridgeGameResult.updateMoveState(moving, canMove);
        return canMove;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
        bridgeGameResult.increaseTryCount();
        bridgeGameResult.initMoveState();
    }

    public boolean hasBridgeToMove(int moveCount) {
        return moveCount < bridge.getSize();
    }

    public boolean isSuccess(int moveCount) {
        return moveCount == bridge.getSize();
    }

    public void succeed() {
        bridgeGameResult.setSuccess();
    }

    public BridgeGameResult getBridgeGameResult() {
        return bridgeGameResult;
    }
}
