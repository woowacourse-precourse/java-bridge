package bridge;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Bridge bridge;
    private BridgeResult bridgeResult = new BridgeResult();
    private int round = 0;
    private int location = -1;
    private boolean alive = true;

    public Player(Bridge bridge) {
        this.bridge = bridge;
    }

    public void startRound() {
        round++;
        location = -1;
        alive = true;
    }

    public boolean movable() {
        if (bridge.hasNextBlock(location) && alive) {
            return true;
        }
        return false;
    }

    public int move(String step) {
        if (movable() && bridge.matchBlockLocation((location + 1), step)) {
            bridgeResult.saveCorrectStep(step);
            return ++location;
        }

        bridgeResult.saveWrongStep(step);
        alive = false;
        return ++location;
    }

    public boolean isSuccess() {
        if (!movable() && alive) {
            return true;
        }
        return false;
    }

    public List<String> getFootPrint() {
        List<String> footPrint = new ArrayList<>();
        for (int prevLocation = 0; prevLocation <= location; prevLocation++) {
            footPrint.add(bridgeResult.getResult(prevLocation));
        }

        return footPrint;
    }
}
