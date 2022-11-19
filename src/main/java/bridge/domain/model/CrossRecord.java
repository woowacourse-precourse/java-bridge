package bridge.domain.model;

import bridge.constants.BridgeDrawer;
import bridge.constants.MovingDirection;
import bridge.constants.MovingPossibility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrossRecord {

    private static Map<MovingDirection, List<String>> crossedBridge = initCrossedBridge();
    private static boolean isFirst = true;

    private static Map<MovingDirection, List<String>> initCrossedBridge() {
        Map<MovingDirection, List<String>> emptyBridge = new HashMap<>();
        emptyBridge.put(MovingDirection.UP, makeEmptyBridge());
        emptyBridge.put(MovingDirection.DOWN, makeEmptyBridge());

        return emptyBridge;
    }

    private static List<String> makeEmptyBridge() {
        List<String> emptyBridge = new ArrayList<>();
        emptyBridge.add(BridgeDrawer.START_OF_BRIDGE.getCharacter());
        emptyBridge.add(BridgeDrawer.END_OF_BRIDGE.getCharacter());

        return emptyBridge;
    }

    public static void recordCrossedBridge(MovingDirection MOVE_TO,
            MovingPossibility MOVING_POSSIBILITY) {
        if (isFirst) {
            recordFirstTime(MOVE_TO, MOVING_POSSIBILITY);
            return;
        }

        recordAfterFirstTime(MOVE_TO, MOVING_POSSIBILITY);
    }

    private static void recordFirstTime(MovingDirection MOVE_TO, MovingPossibility MOVING_POSSIBILITY) {
        isFirst = false;
        for (MovingDirection BRIDGE_DIRECTION : MovingDirection.values()) {
            if (BRIDGE_DIRECTION == MOVE_TO) {
                recordOOrX(BRIDGE_DIRECTION, MOVING_POSSIBILITY);
                continue;
            }
            recordEmptySpace(BRIDGE_DIRECTION);
        }
    }

    private static void recordAfterFirstTime(MovingDirection MOVE_TO,
            MovingPossibility MOVING_POSSIBILITY) {
        for (MovingDirection BRIDGE_DIRECTION : MovingDirection.values()) {
            recordDivideSpace(BRIDGE_DIRECTION);
            if (BRIDGE_DIRECTION == MOVE_TO) {
                recordOOrX(BRIDGE_DIRECTION, MOVING_POSSIBILITY);
                continue;
            }
            recordEmptySpace(BRIDGE_DIRECTION);
        }
    }

    private static void recordOOrX(MovingDirection BRIDGE_DIRECTION,
            MovingPossibility MOVING_POSSIBILITY) {
        int insertIndex = crossedBridge.get(BRIDGE_DIRECTION).size() - 1;
        crossedBridge
                .get(BRIDGE_DIRECTION)
                .add(insertIndex, MOVING_POSSIBILITY.getCharacter());
    }

    private static void recordEmptySpace(MovingDirection BRIDGE_DIRECTION) {
        int insertIndex = crossedBridge.get(BRIDGE_DIRECTION).size() - 1;
        crossedBridge
                .get(BRIDGE_DIRECTION)
                .add(insertIndex, BridgeDrawer.EMPTY_SPACE.getCharacter());
    }

    private static void recordDivideSpace(MovingDirection BRIDGE_DIRECTION) {
        int insertIndex = crossedBridge.get(BRIDGE_DIRECTION).size() - 1;
        crossedBridge
                .get(BRIDGE_DIRECTION)
                .add(insertIndex, BridgeDrawer.DIVIDE_SPACE.getCharacter());
    }

    public static void resetCrossedBridge() {
        isFirst = true;
        crossedBridge = initCrossedBridge();
    }

    public static Map<MovingDirection, String> getCrossedBridge() {
        Map<MovingDirection, String> crossedBridgeForReturn = new HashMap<>();

        for (MovingDirection BRIDGE_DIRECTION : MovingDirection.values()) {
            crossedBridgeForReturn.put(BRIDGE_DIRECTION,
                    String.join("", crossedBridge.get(BRIDGE_DIRECTION)));
        }

        return crossedBridgeForReturn;
    }
}
