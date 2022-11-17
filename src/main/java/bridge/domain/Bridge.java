package bridge.domain;

public class Bridge {
    private BridgeState bridgeState;
    private boolean alreadyCrossed = false;

    private Bridge() {
    }

    private Bridge(BridgeState bridgeState) {
        this.bridgeState = bridgeState;
    }

    public static Bridge create(BridgeState bridgeState) {
        return new Bridge(bridgeState);
    }

    public boolean isAlreadyCrossed() {
        return this.alreadyCrossed;
    }

    public boolean matches(BridgeState bridgeState) {
        return this.bridgeState.equals(bridgeState);
    }

    public void crossing() {
        this.alreadyCrossed = true;
    }
}
