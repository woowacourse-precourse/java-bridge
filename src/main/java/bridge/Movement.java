package bridge;

public enum Movement {
    UP("U"),
    DOWN("D");

    private String movement;

    Movement(String movement) {
        this.movement = movement;
    }

    public String getValue() {
        return movement;
    }
}
