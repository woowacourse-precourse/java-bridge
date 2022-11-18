package bridge.constant;

public enum Movement {
    UP_AND_O("U", "O"),
    UP_AND_X("U", "X"),
    DOWN_AND_O("D", "O"),
    DOWN_AND_X("D", "X");

    private final String direction;
    private final String type;

    Movement(String direction, String type) {
        this.direction = direction;
        this.type = type;
    }

    public String direction() {
        return direction;
    }

    public String type() {
        return type;
    }

    public boolean isAvailable() {
        return type.equals("O");
    }
}
