package bridge.domain.bridgeGame;

import java.util.ArrayList;
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

    private final HashMap<String, List<String>> gameMap;

    private GameMap(HashMap<String, List<String>> gameMap) {
        this.gameMap = gameMap;
    }

    public static GameMap from(HashMap<String, List<String>> gameMap) {
        return new GameMap(gameMap);
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

    public GameMap addGameResult(String direction, boolean success) {
        addBlockMap(direction, GameMapElement.getMapElement(success));
        addBlockMap(getOppositeDirection(direction), GameMapElement.getMapElement());

        return new GameMap(gameMap);
    }

    public GameMap reset() {
        gameMap.put(UPPER_BRIDGE, new ArrayList<>());
        gameMap.put(LOWER_BRIDGE, new ArrayList<>());

        return new GameMap(gameMap);
    }

    @Override
    public String toString() {
        StringJoiner resultMapGenerator = new StringJoiner("\n");
        resultMapGenerator.add(generateMapAt(UPPER_BRIDGE));
        resultMapGenerator.add(generateMapAt(LOWER_BRIDGE));

        return resultMapGenerator.toString();
    }
}
