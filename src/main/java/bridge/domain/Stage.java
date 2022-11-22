package bridge.domain;

import java.util.HashMap;
import java.util.Map;

public class Stage {

    private final Map<String, Tile> tiles;

    public Stage(final String shape) {
        this.tiles = mapTiles(shape);
    }

    private Map<String, Tile> mapTiles(final String shape) {
        Map<String, Tile> tiles = new HashMap<>();
        tiles.put(shape, Tile.PASS);
        return tiles;
    }

    public PlayResult choose(final String shape) {
        Tile status = tiles.getOrDefault(shape, Tile.NO_PASS);

        if (status.isPassable()){
            return PlayResult.PASS;
        }
        return PlayResult.FAIL;
    }
}
