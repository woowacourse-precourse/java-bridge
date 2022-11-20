package bridge.domain;

import bridge.constant.BridgeMapConstants;
import java.util.ArrayList;
import java.util.List;

public class BridgeMap {

    private final List<List<String>> bridgeMap;

    public BridgeMap() {
        bridgeMap = new ArrayList<List<String>>(
                List.of(new ArrayList<String>(),
                        new ArrayList<String>()));
    }

    public List<List<String>> getBridgeMap() {
        return bridgeMap;
    }

    public void update(String direction, boolean gameOver) {
        if (gameOver) {
            markFailedMove(direction);
            return;
        }
        markSuccessfulMove(direction);
    }

    void clear() {
        bridgeMap.get(BridgeMapConstants.UP_SIDE_INDEX).clear();
        bridgeMap.get(BridgeMapConstants.DOWN_SIDE_INDEX).clear();
    }

    private void markFailedMove(String direction) {
        if (direction.equals(Moving.UP.getValue())) {
            bridgeMap.get(BridgeMapConstants.UP_SIDE_INDEX).add(BridgeMapConstants.FAILED_MOVE_MARK);
            bridgeMap.get(BridgeMapConstants.DOWN_SIDE_INDEX).add(BridgeMapConstants.NEVER_STEPPED_MARK);
            return;
        }
        bridgeMap.get(BridgeMapConstants.UP_SIDE_INDEX).add(BridgeMapConstants.NEVER_STEPPED_MARK);
        bridgeMap.get(BridgeMapConstants.DOWN_SIDE_INDEX).add(BridgeMapConstants.FAILED_MOVE_MARK);
    }

    private void markSuccessfulMove(String direction) {
        if (direction.equals(Moving.UP.getValue())) {
            bridgeMap.get(BridgeMapConstants.UP_SIDE_INDEX).add(BridgeMapConstants.SUCCESSFUL_MOVE_FORMAT);
            bridgeMap.get(BridgeMapConstants.DOWN_SIDE_INDEX).add(BridgeMapConstants.NEVER_STEPPED_MARK);
            return;
        }
        bridgeMap.get(BridgeMapConstants.UP_SIDE_INDEX).add(BridgeMapConstants.NEVER_STEPPED_MARK);
        bridgeMap.get(BridgeMapConstants.DOWN_SIDE_INDEX).add(BridgeMapConstants.SUCCESSFUL_MOVE_FORMAT);
    }
}
