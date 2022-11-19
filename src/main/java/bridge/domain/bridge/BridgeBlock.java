package bridge.domain.bridge;

public enum BridgeBlock {
    UP(1, "U"),
    DOWN(0, "D");

    final int number;
    final String direction;

    BridgeBlock(int number, String direction) {
        this.number = number;
        this.direction = direction;
    }

    public int getNumber() {
        return number;
    }

    public String getDirection() {
        return direction;
    }
}
