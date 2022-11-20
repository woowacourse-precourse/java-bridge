package bridge.domain;

public class UserData {

    private static final int START_POSITION = 0;
    private static final int INITIAL_TRY_COUNT = 1;

    private int position;
    private int tryCount;

    public UserData() {
        position = START_POSITION;
        tryCount = INITIAL_TRY_COUNT;
    }

    public void increasePosition() {
        position++;
    }

    public void increaseTryCount() {
        tryCount++;
    }

    public void resetPosition() {
        position = START_POSITION;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }

    public int getTryCount() {
        return tryCount;
    }
}
