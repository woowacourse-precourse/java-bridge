package bridge.domain;

public class BridgeGame {
    private Bridge bridge;
    private PositionTable userTable;
    private int tryNumber = 1;

    private BridgeGame(Bridge bridge, PositionTable userTable) {
        this.bridge = bridge;
        this.userTable = userTable;
    }
    public static BridgeGame start(Bridge bridge, PositionTable userTable) {
        return new BridgeGame(bridge, userTable);
    }

    public void move(String command) {

    }

    public void retry() {
    }

}
