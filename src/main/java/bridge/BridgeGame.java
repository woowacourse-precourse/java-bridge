package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
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
