package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeStatus {
    private final List<String> bridge;
    private final MapMaker mapMaker;
    private int current;

    public BridgeStatus(List<String> bridge) {
        this.bridge = bridge;
        mapMaker = new MapMaker();
        current = 0;
    }

    private boolean isAvailable(String moving) {
        return bridge.get(current++).equals(moving);
    }

    public boolean move(String moving) {
        if (isAvailable(moving)) {
            mapMaker.makeSuccessMap(moving);
            return true;
        }
        mapMaker.makeFailMap(moving);
        return false;
    }

    public void initStatus() {
        mapMaker.initMap();
        current = 0;
    }

    public String toString() {
        return mapMaker.getCurrentMap();
    }


}
