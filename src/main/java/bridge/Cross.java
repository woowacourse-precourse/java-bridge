package bridge;

public enum Cross {

    CAN_CROSS("O", true),
    CAN_NOT_CROSS("X", false);

    private final String mark;
    private final boolean cross;

    Cross(String mark, boolean cross) {
        this.mark = mark;
        this.cross = cross;
    }
}
