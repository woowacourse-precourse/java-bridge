package bridge.model;

import bridge.utils.BridgeMaker;

import static bridge.resources.ErrorMessage.*;
import static bridge.resources.GameCommand.*;

public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private final GameResult gameResult;
    private Bridges bridge;

    public BridgeGame(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
        gameResult = GameResult.getInstance();
    }

    public int createBridge(String size) {
        int bridgeSize = validationAsNumeric(size);
        validationRange(bridgeSize);
        bridge = new Bridges(bridgeMaker.makeBridge(bridgeSize));
        return bridgeSize;
    }

    public String move(String moveSpace, int index) {
        canMove(moveSpace);
        boolean canMove = bridge.judgeMovement(moveSpace, index);
        return gameResult.updateMoveResult(moveSpace, canMove);
    }

    public boolean fail() {
        return gameResult.canNotGo();
    }

    public void retry(String gameCommand) {
        if (RESTART.isEqual(gameCommand)) {
            gameResult.reset();
            return;
        }
        if (QUIT.isEqual(gameCommand)) {
            throw new IllegalStateException(getFinishResult());
        }
        throw new IllegalArgumentException(COMMAND_ERROR);
    }

    public String getFinishResult() {
        return gameResult.toString();
    }

    private int validationAsNumeric(String size) {
        try {
            return Integer.parseInt(size);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NUMERIC_ERROR);
        }
    }

    private void validationRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }
}
