package bridge;

import bridge.constant.Constant;
import bridge.domain.*;

import java.util.List;

public class BridgeGame {
    private final Bridge bridge;
    private final BridgeMap bridgeMap = new BridgeMap();
    private Movement movement = new Movement();
    private int tryCount = Constant.INITIAL_COUNT;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    public void move(Moving moving) {
        movement.saveMoving(moving);
        bridgeMap.addMap(moving, canMove());
    }

    public boolean retry(Command command) {
        if (command.equals(Constant.RETRY)) {
            tryCount++;
            clearGame();
            return true;
        }
        return false;
    }

    private void clearGame() {
        movement = new Movement();
        bridgeMap.clearMap();
    }

    public boolean canMove() {
        return bridge.canMove(movement);
    }

    public boolean isFinish() {
        return bridge.isFinish(movement);
    }

    public String isSuccess() {
        if (isFinish() && canMove()) {
            return Constant.SUCCESS;
        }
        return Constant.FAILURE;
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<List<String>> getMap() {
        return bridgeMap.getMap();
    }
}