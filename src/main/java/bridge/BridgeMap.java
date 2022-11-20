package bridge;

import java.util.List;

public class BridgeMap {

    private final List<List<String>> map;

    public BridgeMap(List<List<String>> map) {
        this.map = map;
    }

    public void updateMap(List<String> partition) {
        this.map.add(partition);
    }

    public List<List<String>> getMap() {
        return this.map;
    }
}
