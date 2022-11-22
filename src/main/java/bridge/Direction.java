package bridge;

/**
 * 다리 구조, 사용자의 이동 커맨드를 관리
 */
public enum Direction {
    UP("U"),
    DOWN("D");
    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public String toString() {
        return direction;
    }
}
