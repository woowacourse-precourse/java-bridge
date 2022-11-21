package bridge.models;

import bridge.enums.BridgeDisplay;
import bridge.enums.BridgeMoving;
import java.util.ArrayList;

public class BridgeResult {

    private int count;
    private boolean success;
    private ArrayList<String>[] result;

    public BridgeResult() {
        count = 0;
        result = new ArrayList[BridgeMoving.values().length];
    }

    public int getCount() {
        return count;
    }

    public boolean isSuccess() {
        return success;
    }
    public int getResultSize() {
        return result[0].size();
    }

    public ArrayList<String>[] getResult() {
        return result;
    }

    public void init() {
        count++;
        for (int index = 0; index < result.length; index++) {
            result[index] = new ArrayList<>();
        }
    }

    public boolean add(String moving, boolean correct) {
        int index = BridgeMoving.valueOf(moving).getNumberNotation();
        String display = BridgeDisplay.getName(correct);
        result[index].add(display);
        for (int anotherIndex = 0; anotherIndex < result.length; anotherIndex++) {
            if (anotherIndex != index) {
                result[anotherIndex].add(" ");
            }
        }
        success = correct;
        return correct;
    }
}
