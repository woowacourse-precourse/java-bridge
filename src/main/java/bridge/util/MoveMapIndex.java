package bridge.util;

public enum MoveMapIndex {
    BRIDGE_SHAPE_INDEX(0),
    CORRECT_INDEX(1),
    UP_INDEX(0),
    DOWN_INDEX(1);

    private final int moveMapIndex;

    MoveMapIndex(int moveMapIndex) {
        this.moveMapIndex = moveMapIndex;
    }

    public int getMoveMapIndex() {
        return moveMapIndex;
    }
}
