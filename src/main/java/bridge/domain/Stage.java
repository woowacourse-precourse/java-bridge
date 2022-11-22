package bridge.domain;

import java.util.HashMap;
import java.util.Map;

public class Stage {

    private final Map<String, TileStatus> tiles;

    public Stage(final String shape) {
        this.tiles = mapTiles(shape);
    }

    private Map<String, TileStatus> mapTiles(final String shape) {
        Map<String, TileStatus> tiles = new HashMap<>();
        tiles.put(shape, TileStatus.PASS);
        return tiles;
    }

    public PlayResult choose(final String shape) {
        TileStatus status = tiles.getOrDefault(shape, TileStatus.NO_PASS);

        if (status.isPassable()){
            return PlayResult.PASS;
        }
        return PlayResult.FAIL;
    }
}
