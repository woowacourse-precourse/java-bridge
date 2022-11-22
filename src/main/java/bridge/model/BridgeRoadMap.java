package bridge.model;

import static bridge.constant.Config.*;

import bridge.constant.message.GameErrorMessage;
import java.util.List;

public class BridgeRoadMap extends RoadMap {
    public BridgeRoadMap(List<String> directions) {
        super(directions);
    }

    @Override
    protected void validate(List<String> directions) {
        int size = directions.size();
        if (size < RANGE_OF_BRIDGE_SIZE_START || size > RANGE_OF_BRIDGE_SIZE_END) {
            throw new IllegalStateException(GameErrorMessage.NO_RANGE_OF_BRIDGE_SIZE.getMessage());
        }
    }

    public boolean isFail(UserRoadMap userRoadMap) {
        int lastRoadPosition = userRoadMap.getSize() - 1;
        return !matchPositionWithRoad(lastRoadPosition, userRoadMap.getRoad(lastRoadPosition));
    }

    public boolean isEnd(UserRoadMap userRoadMap) {
        return getSize() == userRoadMap.getSize();
    }
}
