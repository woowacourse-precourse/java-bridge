package bridge.model;

public class Player {

    public static final int STARTING_POINT = 0;
    public static final int FIRST_TRIAL = 1;

    private int currentPosition;
    private int trialCount;

    private Player() {
        currentPosition = STARTING_POINT;
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
        currentPosition = STARTING_POINT;
    }

    public boolean isAt(int endPoint) {
        return currentPosition == endPoint;
    }

    public void move() {
        currentPosition++;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
