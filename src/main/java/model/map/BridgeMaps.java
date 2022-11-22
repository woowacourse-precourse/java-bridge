package model.map;

import model.bridge.PositionType;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static model.bridge.PositionType.U;

public class BridgeMaps {

    private final Map<PositionType, BridgeMap> maps;

    public BridgeMaps() {
        maps = new EnumMap<>(PositionType.class);
    }

    public Map<PositionType, List<String>> getMaps() {
        Map<PositionType, List<String>> maps = new HashMap<>();
        for (PositionType type : this.maps.keySet()) {
            maps.put(type, getMap(type));
        }
        return Map.copyOf(maps);
    }

    private List<String> getMap(PositionType type) {
        return maps.get(type).getMap();
    }

    public int getStage() {
        BridgeMap map = maps.getOrDefault(U, new BridgeMap());
        return map.getStage();
    }

    public void updateMaps(PositionType playerType, Boolean result) {
        for (PositionType positionType : PositionType.values()) {
            compareType(positionType, playerType, result);
        }
    }

    private void compareType(PositionType positionType, PositionType playerType, Boolean result) {
        if (positionType.equals(playerType)) {
            updateMap(positionType, result);
            return;
        }

        updateMap(positionType, null);
    }

    private void updateMap(PositionType position, Boolean result) {
        BridgeMap map = maps.getOrDefault(position, new BridgeMap());
        map.updateMap(result);
        maps.put(position, map);
    }

    public void reset() {
        maps.forEach((position, map) -> map.reset());
    }
}
