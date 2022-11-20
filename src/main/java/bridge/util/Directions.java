package bridge.util;

public enum Directions {
    UP("U"),
    DOWN("D");

    private final String direction;

    Directions(String direction) {
        this.direction = direction;
    }

    public String getValue () {
        return direction;
    }
}
