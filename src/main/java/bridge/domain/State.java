package bridge.domain;

public enum State {
    CORRECT(" O "),
    WRONG(" X "),
    NONE("   ");

    private String mark;

    State(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return this.mark;
    }
}
