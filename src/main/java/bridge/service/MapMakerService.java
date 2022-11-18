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
            topLow += makeTopLow(i,userBridge.get(i));
            bottomLow += makeBottomLow(i,userBridge.get(i));
            if (i != userBridge.size()-1) {
                topLow += BridgeMap.BRIDGE_DIVISION_MARK.getMark();
                bottomLow += BridgeMap.BRIDGE_DIVISION_MARK.getMark();
            }
        }
        topLow = formatMap(topLow);
        bottomLow = formatMap(bottomLow);
        return Arrays.asList(topLow,bottomLow);
    }

    public String formatMap(String low) {
        return BridgeMap.BRIDGE_START_MARK.getMark()+low+BridgeMap.BRIDGE_END_MARK.getMark();
    }

    public String makeTopLow(int idx, String location) {
        if (this.bridge.get(idx).equals(location)){
            if (location.equals("U")){
                return BridgeMap.SUCCESS_MARK.getMark();
            }
            return BridgeMap.BLANK_MARK.getMark();
        }
        if (location.equals("U")) {
            return BridgeMap.FAIL_MARK.getMark();
        }
        return BridgeMap.BLANK_MARK.getMark();
    }

    public String makeBottomLow(int idx, String location) {
        if (this.bridge.get(idx).equals(location)){
            if (location.equals("U")){
                return BridgeMap.BLANK_MARK.getMark();
            }
            return BridgeMap.SUCCESS_MARK.getMark();
        }
        if (location.equals("U")) {
            return BridgeMap.BLANK_MARK.getMark();
        }
        return BridgeMap.FAIL_MARK.getMark();
    }
}
