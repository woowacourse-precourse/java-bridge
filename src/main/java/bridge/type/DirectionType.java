package bridge.type;

public enum DirectionType {
    UP("U"),
    DOWN("D");

    private final String direction;

    DirectionType(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
