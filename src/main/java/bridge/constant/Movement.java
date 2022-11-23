package bridge.constant;

public enum Movement {

    UP("U", 1),
    DOWN("D", 0);

    private final String upAndDownMovement;
    private final int upAndDown;

    Movement(String upAndDownMovement, int upAndDown) {
        this.upAndDownMovement = upAndDownMovement;
        this.upAndDown = upAndDown;
    }

    public String getUpAndDownMovement() {
        return upAndDownMovement;
    }

    public int getUpAndDown() {
        return upAndDown;
    }
}
