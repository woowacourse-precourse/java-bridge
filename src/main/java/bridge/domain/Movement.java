package bridge.domain;

import bridge.constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class Movement {
    private final List<String> bridge;
    private List<String> movement = new ArrayList<>();
    private int tryCount;
    List<String> topMap = new ArrayList<>();
    List<String> bottomMap = new ArrayList<>();

    public Movement(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canMove(String moving) {
        saveMoving(moving);
        int nowIndex = movement.size() - 1;
        if (!moving.equals(bridge.get(nowIndex))) {
            return false;
        }
        return true;
    }

    private void saveMoving(String moving) {
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
}