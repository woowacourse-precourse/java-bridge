package bridge.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeGameResult {
    private static final String BRIDGE_UP_SIDE_SHAPE = "U";
    private static final String BRIDGE_DOWN_SIDE_SHAPE = "D";
    private static final String NOT_MOVING_SHAPE = " ";
    private static final String BRIDGE_NOT_MOVING = "X";

    private final Map<String, List<String>> result;

    public BridgeGameResult() {
        this.result = new HashMap<>();
        initResult();
    }

    private void initResult() {
        result.put(BRIDGE_UP_SIDE_SHAPE, new ArrayList<>());
        result.put(BRIDGE_DOWN_SIDE_SHAPE, new ArrayList<>());
    }

    public void putMovingResult(String moving, String movingResult) {
        result.get(moving).add(movingResult);
        result.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(moving))
                .forEach(entry -> entry.getValue().add(NOT_MOVING_SHAPE));
    }

    public void clearResult() {
        result.get(BRIDGE_UP_SIDE_SHAPE).clear();
        result.get(BRIDGE_DOWN_SIDE_SHAPE).clear();
    }

    public List<String> getBridgeByShape(String shape) {
        return result.get(shape);
    }
}
