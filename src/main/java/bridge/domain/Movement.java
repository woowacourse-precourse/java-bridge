package bridge.domain;

import bridge.constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class Movement {
    private final List<String> bridge;
    private final BridgeMap bridgeMap = new BridgeMap();
    private List<String> movement = new ArrayList<>();
    private int tryCount = Constant.INITIAL_COUNT;

    public Movement(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canMove() {
        int nowIndex = movement.size() - 1;
        if (!movement.get(nowIndex).equals(bridge.get(nowIndex))) {
            return false;
        }
        return true;
    }

    public void saveMoving(String moving) {
        this.movement.add(moving);
        saveCompareResult(moving);
    }

    public boolean isFinish() {
        if (bridge.size() == movement.size()) {
            return true;
        }
        return false;
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