package bridge.domain;

import bridge.constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class Movement {
    private final Bridge bridge;
    private final BridgeMap bridgeMap = new BridgeMap();
    private List<String> movement = new ArrayList<>();
    private int tryCount = Constant.INITIAL_COUNT;

    public Movement(Bridge bridge) {
        this.bridge = bridge;
    }

    public boolean canMove() {
        int nowIndex = movement.size() - 1;
        return bridge.canMove(nowIndex, movement.get(nowIndex));
    }

    public void saveMoving(String moving) {
        this.movement.add(moving);
        saveCompareResult(moving);
    }
    public boolean isFinish() {
        return bridge.isFinish(movement);
    }

    public void clearMoving() {
        this.movement = new ArrayList<>();
        bridgeMap.clearMap();
        tryCount++;
    }

    public String[] getMap() {
        return bridgeMap.getMap();
    }

    public void saveCompareResult(String moving) {
        String mark = Constant.CORRECT_MARK;
        if (!canMove()) {
            mark = Constant.WRONG_MARK;
        }
        bridgeMap.addMap(moving, mark);
    }

    public int getTryCount() {
        return tryCount;
    }

    public String isSuccess() {
        if (isFinish() && canMove()) {
            return Constant.SUCCESS;
        }
        return Constant.FAILURE;
    }
}