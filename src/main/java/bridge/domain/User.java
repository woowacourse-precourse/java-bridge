package bridge.domain;

import bridge.util.BridgeBlock;
import bridge.util.BridgePosition;
import java.util.ArrayList;
import java.util.List;

public class User {

    private final Bridge bridge;
    private List<String> movements;

    public User(Bridge bridge) {
        this.bridge = bridge;
        initMovements();
    }

    public boolean move(String movingPosition) {
        boolean possibleToMove = bridge.isMovable(movingPosition, movements.size());
        movements.add(movingPosition);
        return possibleToMove;
    }

    public void retry() {
        initMovements();
    }

    private void initMovements() {
        this.movements = new ArrayList<>();
    }

    public String getBlockResult(BridgePosition bridgePosition, int index) {
        if (bridgePosition.isEqualToBridgePosition(movements.get(index))) {
            return getMovedResult(movements.get(index), index);
        }
        return BridgeBlock.NOT_MOVED.getBlock();
    }

    public String getMovedResult(String movingPosition, int index) {
        if (bridge.isMovable(movingPosition, index)) {
            return BridgeBlock.SUCCESS_MOVED.getBlock();
        }
        return BridgeBlock.FAIL_MOVED.getBlock();
    }

    public int getUserPoint() {
        return movements.size();
    }

    public boolean isEndPoint() {
        return bridge.isEndPoint(getUserPoint());
    }
}
