package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
    private List<String> upperBridgeMap = new ArrayList<>();
    private List<String> lowerBridgeMap = new ArrayList<>();

    public BridgeMap() {

    }

    public List<String> getUpperBridgeMap() {
        return upperBridgeMap;
    }

    public List<String> getLowerBridgeMap() {
        return lowerBridgeMap;
    }

    public void initializeBridges() {
        upperBridgeMap = new ArrayList<>();
        lowerBridgeMap = new ArrayList<>();
    }
}
