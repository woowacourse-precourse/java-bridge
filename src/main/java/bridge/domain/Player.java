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

    public boolean isCurrentPosition(int position) {
        return positionIndex == position - 1;
    }

    public boolean isPassedPosition(int position) {
        return positionIndex < position;
    }

    public BridgeTile getMovingLogOf(int index) {
        return movingLog.get(index);
    }
}
