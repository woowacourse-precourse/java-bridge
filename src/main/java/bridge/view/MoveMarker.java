package bridge.view;

public enum MoveMarker {
    CORRECT("O"),
    WRONG("X");

    private final String mark;

    MoveMarker(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
