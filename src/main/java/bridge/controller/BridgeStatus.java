package bridge.controller;

public enum BridgeStatus {
    UP("U", 1),
    DOWN("D", 0);

    private final String moving;
    private final int number;

    BridgeStatus(String moving, int number) {
        this.moving = moving;
        this.number = number;
    }

    public String getMoving() {
        return moving;
    }

    public int getNumber() {
        return number;
    }
}
