package bridge.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeMap {

    private static final String BLANK=" ";
    private List<String> bridgeUpMap;
    private List<String> bridgeDownMap;

    public BridgeMap(int size) {
        bridgeUpMap = new ArrayList<>(Collections.nCopies(size,BLANK));
        bridgeDownMap = new ArrayList<>(Collections.nCopies(size,BLANK));
    }

    public List<String> getBridgeUpMap() {
        return Collections.unmodifiableList(bridgeUpMap);

    }

    public List<String> getBridgeDownMap() {
        return Collections.unmodifiableList(bridgeDownMap);
    }

    public void makeBridgeMap(int location, String moving, String expression) {
        if (moving.equals(Moving.UP.getDescription())) {
            makeBridgeUpMap(location, expression);
        }
        if (moving.equals(Moving.DOWN.getDescription())) {
            makeBridgeDownMap(location, expression);
        }
    }

    public void makeBridgeUpMap(int location, String expression) {
        bridgeUpMap.set(location, expression);
    }


    public void makeBridgeDownMap(int location, String expression) {
        bridgeDownMap.set(location, expression);
    }


}