package bridge.constant;

public enum Movement {

    UP("U", 1),
    DOWN("D", 0);

    private final String upAndDownSide;
    private final int upAndDown;

    Movement(String upAndDownSide, int upAndDown) {
        this.upAndDownSide = upAndDownSide;
        this.upAndDown = upAndDown;
    }

    public String getUpAndDownSide() {
        return upAndDownSide;
    }

    public int getUpAndDown() {
        return upAndDown;
    }
}
