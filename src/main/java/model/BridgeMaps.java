package model;

import java.util.EnumMap;
import java.util.Map;

public class BridgeMaps {
    private final Map<BridgeType, BridgeMap> maps;

    public BridgeMaps() {
        maps = new EnumMap<>(BridgeType.class);
    }
}
