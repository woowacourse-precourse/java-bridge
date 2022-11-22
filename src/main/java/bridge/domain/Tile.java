package bridge.domain;

public class Tile {

    private final TileStatus status;

    public Tile(final TileStatus status) {
        this.status = status;
    }

    public boolean isPassable() {
        return status.isPassable();
    }
}
