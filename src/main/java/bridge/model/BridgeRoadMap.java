package bridge.model;

import java.util.List;

public class BridgeRoadMap extends RoadMap {
    public BridgeRoadMap(List<String> directions) {
        super(directions);
    }

    @Override
    protected void validate(List<String> directions) {
        // TODO: 다리의 크기 유효성 확인,
    }
}
