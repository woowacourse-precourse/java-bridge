package bridge.domain;

public enum Tile {
    PASS,
    NO_PASS;

    public boolean isPassable() {
        return this == PASS;
    }
}
