package bridge.domain;

public class PlayResult {

    private final Direction direction;

    private final Tile tile;

    public PlayResult(final Direction direction, final Tile tile) {
        this.direction = direction;
        this.tile = tile;
    }

    public boolean isPass() {
        return tile.isPassable();
    }

    public boolean isFail() {
        return !tile.isPassable();
    }

    public boolean isPlayerMoveTo(final Direction direction) {
        return this.direction == direction;
    }
}
