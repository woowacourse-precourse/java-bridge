package bridge.domain;

public class Player {

    private static final int ZERO = 0;

    private int currentPosition;
    private int tryCount;
    private boolean isMoving;

    public Player() {
        this.currentPosition = 0;
        this.tryCount = 1;
        this.isMoving = false;
    }

    public void moveOneSpace() {
        currentPosition++;
        isMoving = true;
    }

    public void stopPlayer() {
        isMoving = false;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void resetCurrentPosition() {
        currentPosition = ZERO;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void addOneRetryCount() {
        tryCount++;
    }

    public boolean getMoving() {
        return isMoving;
    }
}
