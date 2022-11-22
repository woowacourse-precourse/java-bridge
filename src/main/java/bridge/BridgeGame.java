package bridge;

import static bridge.validation.BridgeGameValidator.checkMoving;

import bridge.domain.Bridge;
import bridge.domain.BridgeGameResult;

public class BridgeGame {

    private static final String RETRY = "R";

    private Bridge bridge;
    private BridgeGameResult bridgeGameResult;

    public void start() {
        bridgeGameResult = new BridgeGameResult();
        bridgeGameResult.increaseTryCount();
    }

    public void make(int inputSize) {
        this.bridge = new Bridge(inputSize);
    }

    public boolean move(int moveCount, String moving) {
        checkMoving(moving);
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
