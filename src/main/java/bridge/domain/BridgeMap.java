package bridge.domain;

import bridge.constant.Bridge;
import bridge.constant.enums.Moving;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeMap {

    private final List<List<String>> bridgeMap;

    public BridgeMap() {
        bridgeMap = new ArrayList<List<String>>(
                List.of(new ArrayList<String>(),
                        new ArrayList<String>()));
    }

    public List<List<String>> getBridgeMap() {
        return List.of(Collections.unmodifiableList(bridgeMap.get(Bridge.MapConstants.UP_SIDE_INDEX)),
                Collections.unmodifiableList(bridgeMap.get(Bridge.MapConstants.DOWN_SIDE_INDEX)));
    }

    public void update(String direction, boolean gameOver) {
        if (gameOver) {
            markFailedMove(direction);
            return;
        }
        markSuccessfulMove(direction);
    }

    void clear() {
        bridgeMap.get(Bridge.MapConstants.UP_SIDE_INDEX).clear();
        bridgeMap.get(Bridge.MapConstants.DOWN_SIDE_INDEX).clear();
    }

    private void markFailedMove(String direction) {
        if (direction.equals(Moving.UP.getValue())) {
            bridgeMap.get(Bridge.MapConstants.UP_SIDE_INDEX).add(Bridge.MapConstants.FAILED_MOVE_MARK);
            bridgeMap.get(Bridge.MapConstants.DOWN_SIDE_INDEX).add(Bridge.MapConstants.NEVER_STEPPED_MARK);
            return;
        }
        bridgeMap.get(Bridge.MapConstants.UP_SIDE_INDEX).add(Bridge.MapConstants.NEVER_STEPPED_MARK);
        bridgeMap.get(Bridge.MapConstants.DOWN_SIDE_INDEX).add(Bridge.MapConstants.FAILED_MOVE_MARK);
    }

    private void markSuccessfulMove(String direction) {
        if (direction.equals(Moving.UP.getValue())) {
            bridgeMap.get(Bridge.MapConstants.UP_SIDE_INDEX).add(Bridge.MapConstants.SUCCESSFUL_MOVE_FORMAT);
            bridgeMap.get(Bridge.MapConstants.DOWN_SIDE_INDEX).add(Bridge.MapConstants.NEVER_STEPPED_MARK);
            return;
        }
        bridgeMap.get(Bridge.MapConstants.UP_SIDE_INDEX).add(Bridge.MapConstants.NEVER_STEPPED_MARK);
        bridgeMap.get(Bridge.MapConstants.DOWN_SIDE_INDEX).add(Bridge.MapConstants.SUCCESSFUL_MOVE_FORMAT);
    }
}
