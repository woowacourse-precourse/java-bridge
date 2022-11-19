package bridge.domain;

public class Player {

    private static final int ZERO = 0;

    private int currentPosition;
    private int retryCount;
    private boolean isMoving;

    public Player() {
        this.currentPosition = 0;
        this.retryCount = 1;
        this.isMoving = false;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void addOneCurrentPosition() {
        currentPosition++;
    }

    public void resetCurrentPosition() {
        currentPosition = ZERO;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void addOneRetryCount() {
        retryCount++;
    }

    public boolean getMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }
}
