package bridge;

public enum BridgeJoyStick {
    U("U"),
    D("D"),
    R("R"),
    Q("Q");
    private String bridgeJoyStick;

    private BridgeJoyStick(String bridgeJoyStick) {
        this.bridgeJoyStick = bridgeJoyStick;
    }

    public String toString() {
        return bridgeJoyStick;
    }
}
