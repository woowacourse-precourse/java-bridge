package bridge.domain;

import bridge.constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class Movement {
    private final List<String> bridge;
    private List<String> movement = new ArrayList<>();
    private int tryCount = Constant.INITIAL_COUNT;
    List<String> topMap = new ArrayList<>();
    List<String> bottomMap = new ArrayList<>();

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
        this.topMap = new ArrayList<>();
        this.bottomMap = new ArrayList<>();
        tryCount++;
    }

    public String[] getMap() {
        String top = String.join(" | ", topMap);
        String bottom = String.join(" | ", bottomMap);

        return new String[]{top, bottom};
    }

    public void saveCompareResult(String moving) {
        String mark = Constant.CORRECT_MARK;
        if (!canMove()) {
            mark = Constant.WRONG_MARK;
        }
        if (moving.equals(Constant.UP)) {
            addMap(topMap, bottomMap, mark);
            return;
        }
        addMap(bottomMap, topMap, mark);
    }

    private void addMap(List<String> existsBridge, List<String> blankBridge, String mark) {
        existsBridge.add(mark);
        blankBridge.add(Constant.BLANK);
    }

    public int getTryCount() {
        return tryCount;
    }

    public String isSuccess() {
        if (canMove()) {
            return Constant.SUCCESS;
        }
        return Constant.FAILURE;
    }
}