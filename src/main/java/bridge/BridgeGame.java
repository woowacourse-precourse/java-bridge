package bridge;

import bridge.constant.Constant;
import bridge.domain.*;

import java.util.List;

public class BridgeGame {
    private Movement movement;
    private final BridgeMap bridgeMap = new BridgeMap();
    private int tryCount = Constant.INITIAL_COUNT;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    public void move(Moving moving) {
        movement.saveMoving(moving);
        bridgeMap.addMap(moving, canMove());
    }

    public boolean retry(Command command) {
        if (command.isRetry()) {
            tryCount++;
            clearGame();
            return true;
        }
        return false;
    }

    private void clearGame() {
        movement.clearMoving();
        bridgeMap.clearMap();
    }

    private void saveCompareResult(Moving moving) {
        bridgeMap.addMap(moving, movement.canMove());
    }
}