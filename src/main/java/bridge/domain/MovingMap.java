package bridge.domain;

import static bridge.domain.BridgeGame.DOWN_BRIDGE;
import static bridge.domain.BridgeGame.UP_BRIDGE;
import static bridge.domain.MovingMapState.FAIL;
import static bridge.domain.MovingMapState.NOT_GOING;
import static bridge.domain.MovingMapState.SUCCESS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovingMap {

    private final Map<String, List<MovingMapState>> movingMap;

    public MovingMap() {
        movingMap = new HashMap<>();
        movingMap.put(UP_BRIDGE, new ArrayList<>());
        movingMap.put(BridgeGame.DOWN_BRIDGE, new ArrayList<>());
    }

    public void addMoving(String moving, boolean isSuccess) {
        movingMap.forEach((target, stateList) ->
                stateList.add(getMovingMapState(target, moving, isSuccess)));
    }

    private MovingMapState getMovingMapState(String target, String moving, boolean isSuccess) {
        if (!target.equals(moving)) {
            return NOT_GOING;
        }

        if (isSuccess) {
            return SUCCESS;
        }

        return FAIL;
    }

    public MovingMapState getState(String moving, int position) {
        return movingMap.get(moving).get(position);
    }

    public int getLength() {
        return movingMap.get(UP_BRIDGE).size();
    }

    public void clear() {
        movingMap.get(UP_BRIDGE).clear();
        movingMap.get(DOWN_BRIDGE).clear();
    }
}
