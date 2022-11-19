package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int tryCount;
    private int positionIndex;
    private List<Tile> movingLog;
    private boolean aliveState;

    public Player() {
        this.tryCount = 1;
        this.aliveState = true;
        initPosition();
    }

    public int moveForward(Tile targetTile) {
        movingLog.add(targetTile);
        positionIndex++;
        return positionIndex;
    }

    public void die() {
        this.aliveState = false;
    }

    public void resurrect() {
        initPosition();
        tryCount++;
        this.aliveState = true;
    }

    private void initPosition() {
        movingLog = new ArrayList<>();
        this.positionIndex = -1;
    }

    public boolean isCurrentPosition(int position) {
        return positionIndex == position;
    }

    public boolean isPassedPosition(int position) {
        return positionIndex >= position;
    }

    public boolean isAlive() {
        return aliveState;
    }

    public Tile getMovingLogOf(int index) {
        return movingLog.get(index);
    }

    public int getTryCount() {
        return this.tryCount;
    }
}
