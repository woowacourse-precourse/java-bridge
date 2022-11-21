package bridge.domain;

import bridge.constant.Direction;
import bridge.constant.MoveStatus;
import java.util.ArrayList;
import java.util.List;

public class Result {
    private static final int TO_INDEX = 1;

    private final List<MoveStatus> moveStatuses;
    private int location;

    public Result() {
        this.moveStatuses = new ArrayList<>();
        this.location = 0;
    }

    public void update(Bridge bridge, Direction userDirection) {
        moveStatuses.add(MoveStatus.of(bridge.canMove(userDirection, location), userDirection));
        location++;
    }

    public boolean isEnd(Bridge bridge) {
        return !didCrossAtLatestMove() || didArriveEndOfBridge(bridge);
    }

    public boolean isSuccess(Bridge bridge) {
        return didCrossAtLatestMove() && didArriveEndOfBridge(bridge);
    }

    public void reset() {
        this.moveStatuses.clear();
        this.location = 0;
    }

    public List<MoveStatus> getMoveStatuses() {
        return this.moveStatuses;
    }

    private boolean didCrossAtLatestMove() {
        return moveStatuses.get(latestLocation()).didCross();
    }

    private int latestLocation() {
        return moveStatuses.size() - TO_INDEX;
    }

    private boolean didArriveEndOfBridge(Bridge bridge) {
        return bridge.isEnd(location);
    }
}
