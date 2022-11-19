package bridge.domain;

import bridge.constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class Movement {
    private final Bridge bridge;
    private List<Moving> movement = new ArrayList<>();

    public Movement(Bridge bridge) {
        this.bridge = bridge;
    }

    public boolean canMove() {
        int nowIndex = movement.size() - 1;
        return bridge.canMove(nowIndex, movement.get(nowIndex));
    }

    public void saveMoving(Moving moving) {
        this.movement.add(moving);
    }

    public boolean isFinish() {
        return bridge.isFinish(movement);
    }

    public void clearMoving() {
        this.movement = new ArrayList<>();
    }

    public String isSuccess() {
        if (isFinish() && canMove()) {
            return Constant.SUCCESS;
        }
        return Constant.FAILURE;
    }
}