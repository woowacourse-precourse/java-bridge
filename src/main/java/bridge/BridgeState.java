package bridge;

public enum BridgeState {
    UP(1, "U"),
    DOWN(0, "D");
    final int bridgeNumber;
    final String bridgeMark;

    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 20;
    BridgeState(int bridgeNumber, String bridgeMark) {
        this.bridgeNumber = bridgeNumber;
        this.bridgeMark = bridgeMark;
    }

}
