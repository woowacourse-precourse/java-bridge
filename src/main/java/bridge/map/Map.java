package bridge.map;

public enum Map {
    BRIDGE_START("[ "),
    BRIDGE_END(" ]"),
    BLOCK_SECTION(" | "),
    BLOCK_CAN_MOVE("O"),
    BLOCK_CANT_MOVE("X"),
    BLOCK_BLANK(" ");

    private String mark;

    private Map(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
