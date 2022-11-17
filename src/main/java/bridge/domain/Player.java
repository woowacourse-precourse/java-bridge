package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int tryCount;
    private int positionIndex;
    private List<BridgeTile> movingLog;

    public Player() {
        this.tryCount = 1;
        initPosition();
    }

    public int moveForward(BridgeTile targetTile) {
        movingLog.add(targetTile);
        positionIndex++;
        return positionIndex;
    }

    public void die() {
        initPosition();
        tryCount++;
    }

    private void initPosition() {
        movingLog = new ArrayList<>();
        this.positionIndex = -1;
    }

    public boolean isInEndOfBridge(int bridgeSize) {
        return positionIndex == bridgeSize - 1;
    }
}
