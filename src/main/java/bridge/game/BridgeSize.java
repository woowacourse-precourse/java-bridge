package bridge.game;

public enum BridgeSize {

    MINIMUM_LENGTH(1),
    MAXIMUM_LENGTH(2),
    MINIMUM(3),
    MAXIMUM(20);

    private final int number;

    BridgeSize(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
