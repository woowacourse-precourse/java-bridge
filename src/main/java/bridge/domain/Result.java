package bridge.domain;

import bridge.constant.Direction;
import bridge.constant.MoveStatus;
import java.util.ArrayList;
import java.util.List;

public class Result {
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
        return !moveStatuses.get(moveStatuses.size() - 1).didCross() || bridge.isEnd(location);
    }

    public boolean isSuccess(Bridge bridge) {
        return moveStatuses.get(moveStatuses.size() - 1).didCross() && bridge.isEnd(location);
    }

    public void reset() {
        this.moveStatuses.clear();
        this.location = 0;
    }

    public List<MoveStatus> getMoveStatuses() {
        return this.moveStatuses;
    }
}
