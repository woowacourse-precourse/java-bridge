package bridge.domain;

import bridge.GameKeySet;

import java.util.ArrayList;
import java.util.List;

public class BridgeLog {
    private final List<List<String>> map;

    private static final int UP_INDEX = 0;
    private static final int DOWN_INDEX = 1;

    public BridgeLog() {
        this.map = List.of(new ArrayList<>(), new ArrayList<>());
    }

    public void addLog(String bridge, String userCross) {
        map.get(UP_INDEX).add(" ");
        map.get(DOWN_INDEX).add(" ");

        replace(bridge, userCross);
    }

    public void clear() {
        map.get(UP_INDEX).clear();
        map.get(DOWN_INDEX).clear();
    }

    private void replace(String bridge, String userCross) {
        int wentUserPlace = wentUserPlace(userCross);
        String moveResult = moveResult(bridge, userCross);

        map.get(wentUserPlace).set(map.get(UP_INDEX).size() - 1, moveResult);
    }

    private String moveResult(String str1, String str2) {
        if (str1.equals(str2)) {
            return "O";
        }
        return "X";
    }

    private int wentUserPlace(String moveKey) {
        if (moveKey.equals(GameKeySet.UP.getKeySet())) {
            return UP_INDEX;
        }
        return DOWN_INDEX;
    }

    public List<List<String>> getMap() {
        return map;
    }

    public List<String> getMap(int index) {
        return map.get(index);
    }
}
