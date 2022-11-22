package bridge.domain;

public enum Direction {
    UP("U", 1),
    DOWN("D", 0);

    private final String initial;
    private final int bridgeNumber;

    Direction(String initial, int bridgeNumber) {
        this.initial = initial;
        this.bridgeNumber = bridgeNumber;
    }

    public static String getInitial(int bridgeNumber) {
        for(Direction direction : values()) {
            if(direction.bridgeNumber == bridgeNumber) {
                return direction.initial;
            }
        }
        return null;
    }

    public String getInitial() {
        return initial;
    }

    public static Direction of(String direction) {
        if(direction.equals(UP.initial))
            return UP;
        if(direction.equals(DOWN.initial))
            return DOWN;
        return null;
    }
}
