package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    static List<String> trialMap_up = new ArrayList<>();
    static List<String> trialMap_down = new ArrayList<>();
    static final int MAXIMUM_LENGTH = 20;

    public String validCheck(int successCount, int size) {
        if (trialMap_down.contains(" X ") || trialMap_up.contains(" X "))
            return "실패";
        return "성공";
    }

    public void move(String userDirection, List<String> bridge, int successCount) {
        moveUpRoadEqualCount(userDirection, bridge, successCount);
        moveUpRoadUnequalCount(userDirection, bridge, successCount);
        moveDownRoadEqualCount(userDirection, bridge, successCount);
        moveDownRoadUnequalCount(userDirection, bridge, successCount);
    }

    public void moveUpRoadEqualCount(String userDirection, List<String> bridge, int successCount) {
        if (userDirection.equals(bridge.get(successCount))) {
            if (userDirection.equals("U"))
                trialMap_up.add(" O ");
            if (userDirection.equals("D"))
                trialMap_up.add("   ");
        }
    }

    public void moveUpRoadUnequalCount(String userDirection, List<String> bridge, int successCount) {
        if (!userDirection.equals(bridge.get(successCount))) {
            if (userDirection.equals("U"))
                trialMap_up.add(" X ");
            if (userDirection.equals("D"))
                trialMap_up.add("   ");
        }
    }

    public void moveDownRoadEqualCount(String userDirection, List<String> bridge, int successCount) {
        if (userDirection.equals(bridge.get(successCount))) {
            if (userDirection.equals("U"))
                trialMap_down.add("   ");
            if (userDirection.equals("D"))
                trialMap_down.add(" O ");
        }
    }

    public void moveDownRoadUnequalCount(String userDirection, List<String> bridge, int successCount) {
        if (!userDirection.equals(bridge.get(successCount))) {
            if (userDirection.equals("U"))
                trialMap_down.add("   ");
            if (userDirection.equals("D"))
                trialMap_down.add(" X ");
        }
    }


}
