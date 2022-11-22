package bridge.data;

public enum GameMark {
    X("X"),
    O("O"),
    BLANK(" "),
    BRAKETS_LEFT("["),
    BRAKETS_RIGHT("]"),
    COLON(":"),
    VERTICAL_BAR("|");

    private final String mark;

    GameMark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
