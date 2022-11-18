package bridge.enums;

public enum Range {
    STARTING_POINT_INCLUSIVE(3),
    ENDING_POINT_INCLUSIVE(20),
    ;
    private final int point;

    Range(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }
}
