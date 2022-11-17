package bridge;

public enum BridgeState {
    UP(1, "U"),
    DOWN(0, "D");
    final int bridgeNumber;
    final String bridgeMark;
    BridgeState(int bridgeNumber, String bridgeMark) {
        this.bridgeNumber = bridgeNumber;
        this.bridgeMark = bridgeMark;
    }

}
