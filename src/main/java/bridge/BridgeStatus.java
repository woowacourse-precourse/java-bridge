package bridge;

public enum BridgeStatus {
    UP("U", 1),
    DOWN("D", 0);

    private String movement;
    private int number;

    BridgeStatus(String movement, int number) {
        this.movement = movement;
        this.number = number;
    }

    public String getMovement() {
        return movement;
    }

    public int getNumber() {
        return number;
    }
}
