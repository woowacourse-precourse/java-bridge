package bridge;

public enum Direction {

    DOWN("D"),
    UP("U");

    private final String floor;

    Direction(String floor) {
        this.floor = floor;
    }

    public static Direction of(int generate) {
        if (generate == 1) {
            return UP;
        }
        return DOWN;
    }

    public String getFloor() {
        return floor;
    }
}
