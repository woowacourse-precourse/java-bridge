package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<MoveStatus> status;
    private int location;

    public Result() {
        this.status = new ArrayList<>();
        this.location = 0;
    }

    public void update(Bridge bridge, String userDirection) {
        status.add(MoveStatus.of(bridge.canMove(userDirection, location), userDirection));
        location++;
    }

    public boolean isEnd(Bridge bridge) {
        return !status.get(status.size()-1).didCross() || bridge.isEnd(location);
    }
}
