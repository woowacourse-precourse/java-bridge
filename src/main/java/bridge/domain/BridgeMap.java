package bridge.domain;

import bridge.constant.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeMap {
    private List<String> topMap = new ArrayList<>();
    private List<String> bottomMap = new ArrayList<>();

    public void addMap(Moving direction, boolean result) {
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

    public List<List<String>> getMap() {
        return Arrays.asList(topMap, bottomMap);
    }
}