package bridge.constants;

public enum DirectionTable {
    DOWN("D",0,"O"),
    UP("U",1,"O"),
    NOT_DOWN("ND",0,"X"),
    NOT_UP("NU",1,"X");

    private final String initial;
    private final int direction;
    private final String state;

    DirectionTable(String initial, int direction, String state) {
        this.initial = initial;
        this.direction = direction;
        this.state = state;
    }

    public String getInitial() {
        return initial;
    }

    public int getDirection() {
        return direction;
    }

    public String getState() {
        return state;
    }
}
