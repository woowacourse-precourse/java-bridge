package bridge.service;

import bridge.domain.bridgeMap.BridgeMap;

public class BridgeMapService {
    private final static BridgeMapService bridgeMapService = new BridgeMapService();
    private BridgeMap bridgeMap;

    private BridgeMapService() {
    }

    public static BridgeMapService getInstance() {
        return bridgeMapService;
    }

    public void initMap() {
        bridgeMap = BridgeMap.initMap();
    }

    public void generateMap(String direction, boolean crossSuccess) {
        bridgeMap.addCrossResult(direction, crossSuccess);
    }

    public String getBridgeMap() {
        return bridgeMap.toString();
    }

    public void resetBridgeMap() {
        bridgeMap.reset();
    }
}
