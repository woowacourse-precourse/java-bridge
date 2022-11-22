package bridge.domain;

public enum MapFlag {
    START("[ "),
    END(" ]"),
    JOIN(" | "),
    MOVE_SUCCESS("O"),
    MOVE_FAIL("X"),
    MOVE_EMPTY(" ");

    private final String flag;

    MapFlag(String flag) {
        this.flag = flag;
    }

    public String flag() {
        return flag;
    }
}
