package bridge.enums;

/**
 * 다리의 길이로 유효한 범위의 시작점과 끝점을 나타낸다.
 */
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
