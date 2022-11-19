package bridge.domain;

import bridge.constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
    List<String> topMap = new ArrayList<>();
    List<String> bottomMap = new ArrayList<>();

    public void addMap(String direction, boolean result) {
        if (direction.equals(Constant.UP)) {
            addMark(topMap, bottomMap, getMark(result));
            return;
        }
        addMark(bottomMap, topMap, getMark(result));
    }

    private void addMark(List<String> existsBridge, List<String> blankBridge, String mark) {
        existsBridge.add(mark);
        blankBridge.add(Constant.BLANK);
    }

    private String getMark(boolean result) {
        if (result) {
            return Constant.CORRECT_MARK;
        }
        return Constant.WRONG_MARK;
    }
    public void clearMap() {
        topMap = new ArrayList<>();
        bottomMap = new ArrayList<>();
    }

    public String[] getMap() {
        String top = String.join(" | ", topMap);
        String bottom = String.join(" | ", bottomMap);
        return new String[]{top, bottom};
    }
}