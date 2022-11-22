package bridge;

public enum Direction {
    DOWN("D", 0),
    UP("U", 1);

    private final String icon;
    private final int number;

    Direction(String icon, int number) {
        this.icon = icon;
        this.number = number;
    }

    public static Direction valueOfNumber(int number) {
        for (Direction direction : Direction.values()) {
            if (direction.number == number) {
                return direction;
            }
        }
        throw new IllegalArgumentException(String.format("[ERROR] %d에 해당하는 방향이 없습니다.", number));
    }

    public String getIcon() {
        return icon;
    }
}