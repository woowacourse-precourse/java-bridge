package bridge.models;

import bridge.enums.BridgeDisplay;
import bridge.enums.BridgeMoving;
import java.util.ArrayList;

public class BridgeResult {

    private int count;
    private boolean success;
    private ArrayList<String>[] map;

    public BridgeResult() {
        count = 0;
        map = new ArrayList[BridgeMoving.values().length];
    }

    public int getCount() {
        return count;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getMapSize() {
        return map[0].size();
    }

    public ArrayList<String>[] getMap() {
        ArrayList<String>[] mapCopy = new ArrayList[map.length];
        for (int index = 0; index < mapCopy.length; index++) {
            mapCopy[index] = new ArrayList<>();
            mapCopy[index].addAll(map[index]);
        }
        return mapCopy;
    }

    public void init() {
        count++;
        for (int index = 0; index < map.length; index++) {
            map[index] = new ArrayList<>();
        }
    }

    public boolean add(String moving, boolean correct) {
        int index = BridgeMoving.valueOf(moving).getNumberNotation();
        String display = BridgeDisplay.getName(correct);
        map[index].add(display);
        for (int anotherIndex = 0; anotherIndex < map.length; anotherIndex++) {
            if (anotherIndex != index) {
                map[anotherIndex].add(" ");
            }
        }
        success = correct;
        return correct;
    }
}
