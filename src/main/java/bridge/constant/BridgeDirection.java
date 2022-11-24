package bridge.constant;

public enum BridgeDirection {
    UP(1, "U"),
    DOWN(0, "D"),
    NOTING(-1,"N");

    private final int randomNumber;
    private final String direction;

    BridgeDirection(int randomNumber, String direction) {
        this.randomNumber = randomNumber;
        this.direction = direction;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public String getDirection() {
        return direction;
    }
}