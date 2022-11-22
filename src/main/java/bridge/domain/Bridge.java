package bridge.domain;

import java.util.List;

public enum Bridge {
    DOWN("D", 0, List.of(1, 0)), UP("U", 1, List.of(0, 1));

    private final String direction;
    private final int number;
    private final List<Integer> directionIndex;

    Bridge(String direction, int number, List<Integer> directionIndex) {
        this.direction = direction;
        this.number = number;
        this.directionIndex = directionIndex;
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

    public List<Integer> getDirectionIndex() {
        return directionIndex;
    }

    public static Bridge getBridgeByDirection(String direction) {
        if (direction.equals("U")) {
            return UP;
        }
        return DOWN;
    }
}