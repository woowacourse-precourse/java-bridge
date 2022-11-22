package bridge;

public enum Direction {
    UP("U", 1),
    DOWN("D", 0);

    private String charDirection;
    private Integer integerDirection;

    Direction(String charDirection, Integer integerDirection) {
        this.charDirection = charDirection;
        this.integerDirection = integerDirection;
    }

    public String getCharDirection() {
        return charDirection;
    }

    public Integer getIntegerDirection() {
        return integerDirection;
    }
}
