package bridge.domain;

import bridge.constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
    List<String> topMap = new ArrayList<>();
    List<String> bottomMap = new ArrayList<>();

    public void addMap(String direction, String mark) {
        if (direction.equals(Constant.UP)) {
            addMark(topMap, bottomMap, mark);
            return;
        }
        addMark(bottomMap, topMap, mark);
    }

    private void addMark(List<String> existsBridge, List<String> blankBridge, String mark) {
        existsBridge.add(mark);
        blankBridge.add(Constant.BLANK);
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
