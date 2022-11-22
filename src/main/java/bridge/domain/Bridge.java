package bridge.domain;

public enum Bridge {
    DOWN("D", 0), UP("U", 1);

    private final String direction;
    private final int number;

    Bridge(String direction, int number) {
        this.direction = direction;
        this.number = number;
    }

    public boolean isSameDirection(String direction) {
        return this.direction.equals(direction);
    }

    public boolean isSameNumber(int number) {
        return this.number == number;
    }

    public String getDirection() {
        return direction;
    }

    public int getNumber() {
        return number;
    }

    public static Bridge getBridgeByDirection(String direction) {
        if (direction.equals("U")) {
            return UP;
        }
        return DOWN;
    }
}