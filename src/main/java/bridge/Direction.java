package bridge;

public enum Direction {
    DOWN("D", 0, 1),
    UP("U", 1, 0);

    private final String icon;
    private final int decisionCode;
    private final int userMapRow;

    Direction(String icon, int decisionCode, int userMapRow) {
        this.icon = icon;
        this.decisionCode = decisionCode;
        this.userMapRow = userMapRow;
    }

    public static Direction valueOfDecisionCode(int decisionCode) {
        for (Direction direction : Direction.values()) {
            if (direction.decisionCode == decisionCode) {
                return direction;
            }
        }
        throw new IllegalArgumentException(String.format("[ERROR] %d에 해당하는 방향이 없습니다.", decisionCode));
    }

    public static Direction valueOfIcon(String icon) {
        for (Direction direction : Direction.values()) {
            if (direction.icon.equals(icon)) {
                return direction;
            }
        }
        throw new IllegalArgumentException(String.format("[ERROR] %s에 해당하는 방향이 없습니다.", icon));
    }

    public String getIcon() {
        return icon;
    }

    public int getUserMapRow() {
        return userMapRow;
    }
}