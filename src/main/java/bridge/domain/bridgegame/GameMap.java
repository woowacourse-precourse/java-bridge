package bridge.domain.bridgegame;

import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static bridge.BridgeMaker.LOWER_BRIDGE;
import static bridge.BridgeMaker.UPPER_BRIDGE;

public class GameMap {
    private final static String BLOCK_SEPARATOR = " | ";
    private final static String BRIDGE_START_POINT = "[ ";
    private final static String BRIDGE_ENDPOINT = " ]";

    private final HashMap<String, List<String>> gameMap = new HashMap<>();

    private GameMap(List<String> upperBridgeMap, List<String> lowerBridgeMap) {
        gameMap.put(UPPER_BRIDGE, upperBridgeMap);
        gameMap.put(LOWER_BRIDGE, lowerBridgeMap);
    }

    public static GameMap generateMap(List<String> upperBridgeMap, List<String> lowerBridgeMap) {
        return new GameMap(upperBridgeMap, lowerBridgeMap);
    }

    private String generateMapAt(String position) {
        return gameMap.get(position)
                .stream()
                .collect(Collectors.joining(BLOCK_SEPARATOR, BRIDGE_START_POINT, BRIDGE_ENDPOINT));
    }

    private String getOppositeDirection(String direction) {
        if (direction.equals(UPPER_BRIDGE)) {
            return LOWER_BRIDGE;
        }
        return UPPER_BRIDGE;
    }

    private void addBlockMap(String position, String blockMap) {
        List<String> bridgeMap = gameMap.get(position);
        bridgeMap.add(blockMap);
        gameMap.put(position, bridgeMap);
    }

    public void addGameResult(String direction, boolean movingSuccess) {
        addBlockMap(direction, GameMapElement.getMapElement(movingSuccess));
        addBlockMap(getOppositeDirection(direction), GameMapElement.getMapElement());
    }

    @Override
    public String toString() {
        StringJoiner resultMapGenerator = new StringJoiner("\n");
        resultMapGenerator.add(generateMapAt(UPPER_BRIDGE));
        resultMapGenerator.add(generateMapAt(LOWER_BRIDGE));

        return resultMapGenerator.toString();
    }
}
