package bridge.domain;

public class Player {

    private int tryCount;
    private int positionIndex;

    public Player() {
        this.tryCount = 1;
        initPosition();
    }

    public int moveForward() {
        positionIndex++;
        return positionIndex;
    }

    public void die() {
        initPosition();
        tryCount++;
    }

    private void initPosition() {
        this.positionIndex = -1;
    }

    public boolean isInEndOfBridge(int bridgeSize) {
        return positionIndex == bridgeSize;
    }
}
