package bridge.service;

import bridge.domain.BridgeMap;

import java.util.Arrays;
import java.util.List;

public class MapMakerService {

    private final List<String> bridge;

    public MapMakerService(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> makeMap(List<String> userBridge) {
        String topLow = "";
        String bottomLow = "";
        for (int i = 0; i < userBridge.size(); i++) {

        }
        topLow = formatMap(topLow);
        bottomLow = formatMap(bottomLow);
        return Arrays.asList(topLow,bottomLow);
    }

    public String formatMap(String low) {
        return BridgeMap.BRIDGE_START_MARK.getMark()+low+BridgeMap.BRIDGE_END_MARK;
    }


}
