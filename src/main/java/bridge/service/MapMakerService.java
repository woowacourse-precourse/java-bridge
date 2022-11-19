package bridge.service;

import bridge.domain.BridgeMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapMakerService {

    private final List<String> bridge;

    public MapMakerService(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> makeMap(List<String> userBridge) {
        List<String> map = new ArrayList<>(Arrays.asList("", ""));
        for (int i = 0; i < userBridge.size(); i++) {
            map = makeLow(map,userBridge,i);
            if (i != userBridge.size() - 1) {
                map = addDivisionMark((map));
            }
        }
        return formatMap(map);
    }

    public List<String> addDivisionMark(List<String> map) {
        map.set(0, map.get(0) + BridgeMap.BRIDGE_DIVISION_MARK.getMark());
        map.set(1, map.get(1) + BridgeMap.BRIDGE_DIVISION_MARK.getMark());
        return map;
    }

    public List<String> formatMap(List<String> map) {
        map.set(0, BridgeMap.BRIDGE_START_MARK.getMark() + map.get(0) + BridgeMap.BRIDGE_END_MARK.getMark());
        map.set(1, BridgeMap.BRIDGE_START_MARK.getMark() + map.get(1) + BridgeMap.BRIDGE_END_MARK.getMark());
        return map;
    }


    public List<String> makeLow(List<String> map, List<String> userBridge, int idx) {
        map.set(0, map.get(0) + makeTopLow(idx, userBridge.get(idx)));
        map.set(1, map.get(1) + makeBottomLow(idx, userBridge.get(idx)));
        return map;
    }

    public String makeTopLow(int idx, String location) {
        if (this.bridge.get(idx).equals(location)) {
            if (location.equals("U")) {
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
        if (this.bridge.get(idx).equals(location)) {
            if (location.equals("U")) {
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
