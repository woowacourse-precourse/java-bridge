package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGameResult;

public class BridgeGame {

    private static final String RETRY = "R";

    private final Bridge bridge;
    private final BridgeGameResult bridgeGameResult = new BridgeGameResult();

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    public void start() {
        bridgeGameResult.increaseTryCount();
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

    public boolean doesRetry(String command) {
        return command.equals(RETRY);
    }

    public BridgeGameResult getBridgeGameResult() {
        return bridgeGameResult;
    }
}
