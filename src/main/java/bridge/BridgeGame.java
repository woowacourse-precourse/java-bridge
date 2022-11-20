package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGameResult;

public class BridgeGame {

    private final Bridge bridge;
    private final BridgeGameResult bridgeGameResult;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.bridgeGameResult = new BridgeGameResult();
    }

    public boolean move(int moveCount, String moving) {
        boolean canMove = bridge.canMove(moveCount, moving);
        bridgeGameResult.updateMoveState(moving, canMove);
        return canMove;
    }

    public void retry() {
        bridgeGameResult.increaseTryCount();
        bridgeGameResult.initMoveState();
    }

    public boolean hasBridgeToMove(int moveCount) {
        return moveCount < bridge.getSize();
    }

    public void succeed() {
        bridgeGameResult.setSuccess();
    }

    public BridgeGameResult getBridgeGameResult() {
        return bridgeGameResult;
    }
}
