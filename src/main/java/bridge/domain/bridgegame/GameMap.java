package bridge.domain.bridgegame;

import java.util.List;

public class GameMap {

    private List<String> gameMap;

    private GameMap(List<String> gameMap) {
        this.gameMap = gameMap;
    }

    public static GameMap from(List<String> gameMap) {
        return new GameMap(gameMap);
    }
}
