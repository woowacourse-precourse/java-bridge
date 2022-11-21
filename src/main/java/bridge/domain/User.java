package bridge.domain;

public class User {

    private static final int INIT_POSITION = 0;
    private static final int INIT_TRIAL = 1;

    private int position;
    private int trial;

    public User() {
        this.position = INIT_POSITION;
        this.trial = INIT_TRIAL;
    }

    public void updatePosition() {
        position++;
    }

    public void retry() {
        position = 0;
        trial++;
    }

    public boolean isArrived(Bridge bridge) {
        return position == bridge.getSize();
    }

    public int getPosition() {
        return position;
    }

    public int getTrial() {
        return trial;
    }
}
