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

        changeResultOfMove(bridge, userCross);
    }

    public void clear() {
        map.get(UP_INDEX).clear();
        map.get(DOWN_INDEX).clear();
    }

    private void changeResultOfMove(String bridge, String userCross) {
        int index = indexOfUserMove(userCross);
        String result = resultOfMove(bridge, userCross);

        map.get(index).set(map.get(UP_INDEX).size() - 1, result);
    }

    private String resultOfMove(String generatreBridgeFoothold, String userMoveBridgeFoothold) {
        if (generatreBridgeFoothold.equals(userMoveBridgeFoothold)) {
            return "O";
        }
        return "X";
    }

    private int indexOfUserMove(String userMove) {
        if (userMove.equals(GameKeySet.UP.getKeySet())) {
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
