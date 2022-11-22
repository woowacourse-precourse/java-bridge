package bridge;

public class BridgeGame {
    private final Bridge bridge;
    private int tryCount = 1;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean move(String moving) {
        bridge.getPlayer().setLastMoving(moving);
        if (bridge.possibleMove(moving)) {
            bridge.getPlayer().locationUpdate();
            bridge.setCorrect(true);
            return true;
        }
        bridge.setCorrect(false);
        return false;
    }

    public boolean retry(String input) {
        if (input.equals("R")) {
            tryCount++;
            bridge.setPlayer(new Player());
            return true;
        }
        return false;
    }
}
