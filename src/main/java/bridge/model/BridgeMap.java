package bridge.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeMap {

    private List<String> bridgeUpMap;
    private List<String> bridgeDownMap;

    public BridgeMap(int size) {
        bridgeUpMap = new ArrayList<>();
        bridgeDownMap = new ArrayList<>();
        initBridgeMap(size);
    }

    public List<String> getBridgeUpMap() {
        return Collections.unmodifiableList(bridgeUpMap);

    }

    public List<String> getBridgeDownMap() {
        return Collections.unmodifiableList(bridgeDownMap);
    }

    public void makeBridgeMap(int location, String moving, String expression) {
        if (moving.equals("U")) {
            makeBridgeUpMap(location, expression);
        }
        if (moving.equals("D")) {
            makeBridgeDownMap(location, expression);
        }
    }

    public void makeBridgeUpMap(int location, String expression) {
        bridgeUpMap.set(location, expression);
    }


    public void makeBridgeDownMap(int location, String expression) {
        bridgeDownMap.set(location, expression);
    }


    public void initBridgeMap(int size) {
        for (int i = 0; i < size; i++) {
            bridgeUpMap.add(" ");
            bridgeDownMap.add(" ");
        }
    }
}