package bridge.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeMap {

    private static final String BLANK=" ";
    private static List<String> bridgeUpMap;
    private static List<String> bridgeDownMap;

    private static BridgeMap bridgeMap = null;

    private BridgeMap(int size) {
        bridgeUpMap = new ArrayList<>(Collections.nCopies(size,BLANK));
        bridgeDownMap = new ArrayList<>(Collections.nCopies(size,BLANK));
    }

    public static BridgeMap createBridgeMap(int size){
        return new BridgeMap(size);
    }


    public static List<String> getBridgeUpMap() {
        return Collections.unmodifiableList(bridgeUpMap);

    }

    public static List<String> getBridgeDownMap() {
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