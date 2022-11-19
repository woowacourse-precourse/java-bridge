package bridge.domain.model;

import bridge.constants.BridgeDrawer;
import bridge.constants.MovingDirection;
import bridge.constants.MovingPossibility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrossRecord {

    private Map<MovingDirection, List<String>> crossedBridge = new HashMap<>();
    private boolean isFirst = true;

    public CrossRecord() {
        initCrossedBridge();
    }

    private void initCrossedBridge() {
        crossedBridge.put(MovingDirection.UP, makeEmptyBridge());
        crossedBridge.put(MovingDirection.DOWN, makeEmptyBridge());
    }

    private List<String> makeEmptyBridge() {
        List<String> emptyBridge = new ArrayList<>();
        emptyBridge.add(BridgeDrawer.START_OF_BRIDGE.getCharacter());
        emptyBridge.add(BridgeDrawer.END_OF_BRIDGE.getCharacter());

        return emptyBridge;
    }

    public void recordCrossedBridge(MovingDirection DIRECTION,
            MovingPossibility MOVING_POSSIBILITY) {
        if (isFirst) {
            isFirst = false;
            for (Map.Entry<MovingDirection, List<String>> oneBridge : crossedBridge.entrySet()) {
                List<String> drawnBridge = oneBridge.getValue();
                if (oneBridge.getKey() == DIRECTION) {
                    drawnBridge.add(drawnBridge.size() - 1, MOVING_POSSIBILITY.getCharacter());
                } else {
                    drawnBridge.add(drawnBridge.size() - 1, BridgeDrawer.EMPTY_SPACE.getCharacter());
                }
            }
        } else {
            for (Map.Entry<MovingDirection, List<String>> oneBridge : crossedBridge.entrySet()) {
                List<String> drawnBridge = oneBridge.getValue();
                drawnBridge.add(drawnBridge.size() - 1, BridgeDrawer.DIVIDE_SPACE.getCharacter());

                if (oneBridge.getKey() == DIRECTION) {
                    drawnBridge.add(drawnBridge.size() - 1, MOVING_POSSIBILITY.getCharacter());
                    continue;
                }

                drawnBridge.add(drawnBridge.size() - 1, BridgeDrawer.EMPTY_SPACE.getCharacter());
            }
        }
    }

    public void resetCrossedBridge() {
        isFirst = true;
        initCrossedBridge();
    }

    public Map<MovingDirection, String> getCrossedBridge() {
        Map<MovingDirection, String> crossedBridgeForReturn = new HashMap<>();

        for (MovingDirection DIRECTION : MovingDirection.values()) {
            crossedBridgeForReturn.put(DIRECTION, String.join("", crossedBridge.get(DIRECTION)));
        }
        return crossedBridgeForReturn;
    }
}
