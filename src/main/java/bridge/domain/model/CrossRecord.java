package bridge.domain.model;

import bridge.constants.BridgeDrawer;
import bridge.constants.Direction;
import bridge.constants.MovingPossibility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrossRecord {

    private static Map<Direction, List<String>> crossedBridge = initCrossedBridge();
    private static boolean isFirst = true;

    private static Map<Direction, List<String>> initCrossedBridge() {
        Map<Direction, List<String>> emptyBridge = new HashMap<>();
        emptyBridge.put(Direction.UP, makeEmptyBridge());
        emptyBridge.put(Direction.DOWN, makeEmptyBridge());

        return emptyBridge;
    }

    private static List<String> makeEmptyBridge() {
        List<String> emptyBridge = new ArrayList<>();
        emptyBridge.add(BridgeDrawer.START_OF_BRIDGE.getCharacter());
        emptyBridge.add(BridgeDrawer.END_OF_BRIDGE.getCharacter());

        return emptyBridge;
    }

    public static void recordCrossedBridge(Direction MOVE_TO,
            MovingPossibility MOVING_POSSIBILITY) {
        if (isFirst) {
            recordFirstTime(MOVE_TO, MOVING_POSSIBILITY);
            return;
        }

        recordAfterFirstTime(MOVE_TO, MOVING_POSSIBILITY);
    }

    private static void recordFirstTime(Direction MOVE_TO, MovingPossibility MOVING_POSSIBILITY) {
        isFirst = false;
        for (Direction BRIDGE_DIRECTION : Direction.values()) {
            if (BRIDGE_DIRECTION == MOVE_TO) {
                recordOOrX(BRIDGE_DIRECTION, MOVING_POSSIBILITY);
                continue;
            }
            recordEmptySpace(BRIDGE_DIRECTION);
        }
    }

    private static void recordAfterFirstTime(Direction MOVE_TO,
            MovingPossibility MOVING_POSSIBILITY) {
        for (Direction BRIDGE_DIRECTION : Direction.values()) {
            recordDivideSpace(BRIDGE_DIRECTION);
            if (BRIDGE_DIRECTION == MOVE_TO) {
                recordOOrX(BRIDGE_DIRECTION, MOVING_POSSIBILITY);
                continue;
            }
            recordEmptySpace(BRIDGE_DIRECTION);
        }
    }

    private static void recordOOrX(Direction BRIDGE_DIRECTION,
            MovingPossibility MOVING_POSSIBILITY) {
        int insertIndex = crossedBridge.get(BRIDGE_DIRECTION).size() - 1;
        crossedBridge
                .get(BRIDGE_DIRECTION)
                .add(insertIndex, MOVING_POSSIBILITY.getCharacter());
    }

    private static void recordEmptySpace(Direction BRIDGE_DIRECTION) {
        int insertIndex = crossedBridge.get(BRIDGE_DIRECTION).size() - 1;
        crossedBridge
                .get(BRIDGE_DIRECTION)
                .add(insertIndex, BridgeDrawer.EMPTY_SPACE.getCharacter());
    }

    private static void recordDivideSpace(Direction BRIDGE_DIRECTION) {
        int insertIndex = crossedBridge.get(BRIDGE_DIRECTION).size() - 1;
        crossedBridge
                .get(BRIDGE_DIRECTION)
                .add(insertIndex, BridgeDrawer.DIVIDE_SPACE.getCharacter());
    }

    public static void resetCrossedBridge() {
        isFirst = true;
        crossedBridge = initCrossedBridge();
    }

    public static Map<Direction, String> getCrossedBridge() {
        Map<Direction, String> crossedBridgeForReturn = new HashMap<>();

        for (Direction BRIDGE_DIRECTION : Direction.values()) {
            crossedBridgeForReturn.put(BRIDGE_DIRECTION,
                    String.join("", crossedBridge.get(BRIDGE_DIRECTION)));
        }

        return crossedBridgeForReturn;
    }
}
