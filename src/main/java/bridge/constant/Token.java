package bridge.constant;

public enum Token {
    UP("U"),
    DOWN("D"),
    RESTART("R"),
    QUIT("Q");

    private final String mark;

    Token(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
