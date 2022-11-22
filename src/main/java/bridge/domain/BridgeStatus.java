package bridge.domain;

public enum BridgeStatus {
    INIT("   "),
    SUCCESS(" O "),
    FAIL(" X ");

    public String buildBridge;

    BridgeStatus(String printBridge) {
        this.buildBridge = printBridge;
    }
}
