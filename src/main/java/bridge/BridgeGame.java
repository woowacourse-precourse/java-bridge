package bridge;

import static bridge.validation.CommonValidator.checkCommand;
import static bridge.validation.CommonValidator.checkMoving;

import bridge.domain.Bridge;
import bridge.domain.BridgeGameResult;
import bridge.domain.BridgeMoveState;
import java.util.List;

public class BridgeGame {

    private static final String RETRY = "R";

    private Bridge bridge;
    private BridgeGameResult bridgeGameResult;

    public void start() {
        bridgeGameResult = new BridgeGameResult();
        bridgeGameResult.increaseTryCount();
    }

    public void make(int size) {
        this.bridge = new Bridge(size);
    }

    public boolean move(String moving) {
        checkMoving(moving);
        boolean canMove = bridge.canMove(bridgeGameResult.getMoveCount(), moving);
        bridgeGameResult.updateMoveState(canMove);
        bridgeGameResult.updateResult(bridge.getSize());
        return canMove;
    }

    public boolean retry(String command) {
        checkCommand(command);
        if (command.equals(RETRY)) {
            bridgeGameResult.increaseTryCount();
            bridgeGameResult.initMoveState();
            return true;
        }
        return false;
    }

    public boolean hasBridgeToMove() {
        return bridgeGameResult.getMoveCount() < bridge.getSize();
    }

    public boolean isSuccess() {
        return bridgeGameResult.isSuccess();
    }

    public List<String> getBridge() {
        return bridge.getBridge();
    }

    public BridgeGameResult getBridgeGameResult() {
        return bridgeGameResult;
    }

    public BridgeMoveState getMoveState() {
        return bridgeGameResult.getMoveState();
    }
}
