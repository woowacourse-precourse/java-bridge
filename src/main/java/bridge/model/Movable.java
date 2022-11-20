package bridge.model;

public enum Movable {
    O("O", true),
    X("X", false),
    BLANK(" ", false);

    private final String mark;
    private final boolean canMovable;

    Movable(String mark, boolean canMovable) {
        this.mark = mark;
        this.canMovable = canMovable;
    }

    public String getMark() {
        return mark;
    }

    public boolean isMovable() {
        return canMovable;
    }
}
