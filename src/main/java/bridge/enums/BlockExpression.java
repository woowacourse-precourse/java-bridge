package bridge.enums;

public enum BlockExpression {
    SAME("O"),
    DIFF("X"),
    EMPTY(" ");

    private final String mark;

    BlockExpression(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
