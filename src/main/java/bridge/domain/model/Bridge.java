package bridge.domain.model;

import bridge.constants.Direction;
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

    public static MovingPossibility checkMovingPossibility(int space, Direction DIRECTION) {
        if (!Bridge.bridgeCreated) {
            throw new IllegalStateException("[ERROR] 다리가 생성되지 않았습니다.");
        }

        if (bridge.get(space).equals(DIRECTION.getDirection())) {
            return MovingPossibility.CAN_MOVE;
        }
        return MovingPossibility.CAN_NOT_MOVE;
    }

    public static int getBridgeSize() {
        return Bridge.bridge.size();
    }
}
