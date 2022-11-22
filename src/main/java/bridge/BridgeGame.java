package bridge;

public class BridgeGame {

    private final Bridge bridge;
    private final Map map;
    private Cross cross;

    public BridgeGame(Bridge bridge, Map map) {
        this.bridge = bridge;
        this.map = map;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public void move() {
    }

    public void retry() {
    }
}
