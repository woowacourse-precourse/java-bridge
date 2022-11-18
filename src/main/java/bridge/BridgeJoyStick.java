package bridge;

public enum BridgeJoyStick {
    U("U"),
    D("D");

    private String bridgeJoyStick;

    private BridgeJoyStick(String bridgeJoyStick) {
        this.bridgeJoyStick = bridgeJoyStick;
    }

    public String toString() {
        return bridgeJoyStick;
    }
}
