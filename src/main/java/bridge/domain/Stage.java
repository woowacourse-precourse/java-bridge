package bridge.domain;

import java.util.HashMap;
import java.util.Map;

public class Stage {

    private final Map<Direction, Tile> tiles;

    public Stage(final String shape) {
        this.tiles = mapTiles(shape);
    }

    private Map<Direction, Tile> mapTiles(final String shape) {
        Map<Direction, Tile> tiles = new HashMap<>();
        for (Direction direction : Direction.values()) {
            tiles.put(direction, Tile.NO_PASS);
        }
        tiles.put(Direction.of(shape), Tile.PASS);
        return tiles;
    }

    public PlayResult choose(final Direction direction) {
        return new PlayResult(direction, tiles.getOrDefault(direction, Tile.NO_PASS));
    }
}
