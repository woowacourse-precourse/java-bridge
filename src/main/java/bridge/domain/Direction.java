package bridge.domain;

public enum Direction {
    DOWN("D", 0),
    UP("U", 1);

    private final String value;
    private final int num;

    Direction(String value, int num) {
        this.value = value;
        this.num = num;
    }

    public static Direction get(String input) {
        if (input.equals("D")) {
            return DOWN;
        }
        return UP;
    }

    public String getValue() {
        return this.value;
    }

    public int getNum() {
        return this.num;
    }
}
