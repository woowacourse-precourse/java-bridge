package bridge;

/**
 * 이동 방향 문자열, 정수 상태 상수 정의
 */
public enum MoveDirection {
    UP("U", 1),
    DOWN("D", 0);

    private String directionString;
    private int directionInteger;

    MoveDirection(String directionString, int directionInteger) {
        this.directionString = directionString;
        this.directionInteger = directionInteger;
    }

    public String getDirectionString() {
        return directionString;
    }

    public int getDirectionInteger() {
        return directionInteger;
    }


}
