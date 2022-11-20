package model;

import java.util.EnumMap;
import java.util.Map;

import static model.BridgeType.UP;

public class BridgeMaps {
    private final Map<BridgeType, BridgeMap> maps;

    public BridgeMaps() {
        maps = new EnumMap<>(BridgeType.class);
    }

    public int getStage() {
        BridgeMap map = maps.getOrDefault(UP, new BridgeMap());
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

    public String getPrintMap(BridgeType type) {
        return maps.get(type).getPrintMap();
    }

    public void reset() {
        maps.forEach((type, map) -> map.reset());
    }
}
