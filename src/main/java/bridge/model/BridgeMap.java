package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
    private final List<String> upperBridgeMap = new ArrayList<>();
    private final List<String> lowerBridgeMap = new ArrayList<>();
    
    public List<String> getUpperBridgeMap() {
        return upperBridgeMap;
    }

    public List<String> getLowerBridgeMap() {
        return lowerBridgeMap;
    }

    public void initializeBridges() {
        upperBridgeMap.clear();
        lowerBridgeMap.clear();
    }
}
