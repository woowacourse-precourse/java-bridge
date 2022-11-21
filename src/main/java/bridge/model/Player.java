package bridge.model;

public class Player {

    public static final int STARTING_POINT = 0;
    public static final int FIRST_TRIAL = 1;

    private int position;
    private int trialCount;

    private Player() {
        position = STARTING_POINT;
        trialCount = FIRST_TRIAL;
    }

    public static Player init() {
        return new Player();
    }

    public int getTrialCount() {
        return trialCount;
    }

    public void retry() {
        trialCount++;
        position = STARTING_POINT;
    }

    public boolean isAt(int endPoint) {
        return position == endPoint;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
