package model;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static model.BridgeType.U;

public class BridgeMaps {
    private final Map<BridgeType, BridgeMap> maps;

    public BridgeMaps() {
        maps = new EnumMap<>(BridgeType.class);
    }

    public Map<BridgeType, List<String>> getMaps() {
        Map<BridgeType, List<String>> maps = new HashMap<>();
        for (BridgeType type : this.maps.keySet()) {
            maps.put(type, getMap(type));
        }
        return Map.copyOf(maps);
    }

    private List<String> getMap(BridgeType type) {
        return maps.get(type).getMap();
    }

    public int getStage() {
        BridgeMap map = maps.getOrDefault(U, new BridgeMap());
        return map.getStage();
    }

    public void updateMaps(BridgeType playerType, Boolean result) {
        for (BridgeType bridgeType : BridgeType.values()) {
            compareType(bridgeType, playerType, result);
        }
    }

    private void compareType(BridgeType bridgeType, BridgeType playerType, Boolean result) {
        if (bridgeType.isEquals(playerType)) {
            updateMap(bridgeType, result);
            return;
        }

        updateMap(bridgeType, null);
    }

    private void updateMap(BridgeType type, Boolean result) {
        BridgeMap map = maps.getOrDefault(type, new BridgeMap());
        map.updateMap(result);
        maps.put(type, map);
    }

    public void reset() {
        maps.forEach((type, map) -> map.reset());
    }
}
