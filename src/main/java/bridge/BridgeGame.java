package bridge;

public class BridgeGame {

    private final Bridge bridge;

    private BridgeGame(final Bridge bridge) {
        this.bridge = bridge;
    }

    public static BridgeGame of(final Bridge bridge) {
        return new BridgeGame(bridge);
    }

    public void move() {
    }

    public void retry() {
    }
}
