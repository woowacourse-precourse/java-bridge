package bridge.model;

public enum Movable {
    O("O", true),
    X("X", false),
    BLANK(" ", false);

    private final String mark;
    private final boolean isMovable;

    Movable(String mark, boolean isMovable) {
        this.mark = mark;
        this.isMovable = isMovable;
    }

    public String getMark() {
        return mark;
    }

    public boolean isMovable() {
        return isMovable;
    }
}
