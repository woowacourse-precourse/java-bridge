package bridge.domain;

public enum TileStatus {
    PASS,
    NO_PASS;

    public boolean isPassable() {
        return this == PASS;
    }
}
