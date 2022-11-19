package bridge.domain.model;

import bridge.constants.MovingPossibility;
import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private static List<String> bridge = new ArrayList<>();
    private static boolean bridgeCreated = false;

    public static boolean setBridge(List<String> passedBridge) {
        if (!Bridge.bridgeCreated) {
            Bridge.bridge = passedBridge;
            Bridge.bridgeCreated = true;
            return true;
        }
        return false;
    }

    public static MovingPossibility checkMovingPossibility(Integer space, String direction) {
        if (!Bridge.bridgeCreated) {
            throw new IllegalStateException("[ERROR] 다리가 생성되지 않았습니다.");
        }

        if (bridge.get(space).equals(direction)) {
            return MovingPossibility.CAN_MOVE;
        }
        return MovingPossibility.CAN_NOT_MOVE;
    }
}
