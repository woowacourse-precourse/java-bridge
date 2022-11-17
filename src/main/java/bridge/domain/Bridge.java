package bridge.domain;

public class Bridge {
    private BridgeState bridgeState;
    private boolean alreadyCrossed;

    private Bridge() {
    }

    private Bridge(BridgeState bridgeState, boolean alreadyCrossed) {
        this.bridgeState = bridgeState;
        this.alreadyCrossed = alreadyCrossed;
    }

    public static Bridge create(BridgeState bridgeState, boolean alreadyCrossed) {
        return new Bridge(bridgeState, alreadyCrossed);
    }
}
