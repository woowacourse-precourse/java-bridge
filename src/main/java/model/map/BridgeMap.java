package model.map;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
    private final List<String> map;

    public BridgeMap() {
        map = new ArrayList<>();
    }

    public List<String> getMap() {
        return List.copyOf(map);
    }

    public int getStage() {
        return map.size();
    }

    public void updateMap(Boolean result) {
        map.add(MapType.getMarkByBoolean(result));
    }

    public void reset() {
        map.clear();
    }
}
