package bridge.domain.bridgeMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static bridge.BridgeMaker.LOWER_BRIDGE;
import static bridge.BridgeMaker.UPPER_BRIDGE;

public class BridgeMap {
    private final static String BLOCK_SEPARATOR = " | ";
    private final static String BRIDGE_START_POINT = "[ ";
    private final static String BRIDGE_ENDPOINT = " ]";

    private final HashMap<String, List<MapElement>> bridgeMap;

    private BridgeMap(HashMap<String, List<MapElement>> bridgeMap) {
        this.bridgeMap = bridgeMap;
    }

    public static BridgeMap initMap() {
        HashMap<String, List<MapElement>> bridgeMap = new HashMap<>();
        bridgeMap.put(UPPER_BRIDGE, new ArrayList<>());
        bridgeMap.put(LOWER_BRIDGE, new ArrayList<>());

        return new BridgeMap(bridgeMap);
    }

    private String generateMapAt(String position) {
        return bridgeMap.get(position)
                .stream()
                .map(MapElement::toString)
                .collect(Collectors.joining(BLOCK_SEPARATOR, BRIDGE_START_POINT, BRIDGE_ENDPOINT));
    }

    private String getOppositeDirection(String direction) {
        if (direction.equals(UPPER_BRIDGE)) {
            return LOWER_BRIDGE;
        }
        return UPPER_BRIDGE;
    }

    private void addBlockMap(String direction, MapElement blockMap) {
        bridgeMap.get(direction).add(blockMap);
    }

    public void addCrossResult(String direction, boolean success) {
        addBlockMap(direction, MapElement.getMapElement(success));
        addBlockMap(getOppositeDirection(direction), MapElement.getMapElement());
    }

    public void reset() {
        bridgeMap.put(UPPER_BRIDGE, new ArrayList<>());
        bridgeMap.put(LOWER_BRIDGE, new ArrayList<>());
    }

    @Override
    public String toString() {
        StringJoiner mapGenerator = new StringJoiner("\n");
        mapGenerator.add(generateMapAt(UPPER_BRIDGE));
        mapGenerator.add(generateMapAt(LOWER_BRIDGE));

        return mapGenerator.toString();
    }
}
