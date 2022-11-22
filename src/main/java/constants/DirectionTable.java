package constants;

public enum DirectionTable {
    DOWN("D", 0, "O"),
    UP("U", 1, "O"),
    NOT_DOWN("ND", 0, "X"),
    NOT_UP("NU", 1, "X");

    private final String initial;
    private final int directionNumber;
    private final String condition;

    DirectionTable(String initial, int directionNumber, String condition) {
        this.initial = initial;
        this.directionNumber = directionNumber;
        this.condition = condition;
    }

    public String getInitial() {
        return initial;
    }

    public int getDirectionNumber() {
        return directionNumber;
    }

    public String getCondition() {
        return condition;
    }
}
