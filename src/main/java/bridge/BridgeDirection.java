package bridge;

public enum BridgeDirection {
    DOWN("D", 0),
    UP("U", 1);

    private String direction;
    private int bridgeRandomNumber;

    BridgeDirection(String direction, int bridgeRandomNumber) {
        this.direction = direction;
        this.bridgeRandomNumber = bridgeRandomNumber;
    }

    public String getDirection() {
        return direction;
    }

    public int getBridgeRandomNumber() {
        return bridgeRandomNumber;
    }
}

