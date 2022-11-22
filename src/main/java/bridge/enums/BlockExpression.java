package bridge.enums;

public enum BlockExpression {
    Same("O"),
    Diff("X"),
    Empty(" ");

    private final String mark;

    BlockExpression(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
