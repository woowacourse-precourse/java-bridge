package bridge.domain;

public class User {
    private int moveCount;
    private int trial;

    public User() {
        moveCount = 0;
        trial = 0;
    }

    public void move() {
        moveCount += 1;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public int getTrial() {
        return trial;
    }

    public void retry() {
        clearUserMove();
        addTrialCount();
    }

    private void clearUserMove() {
        moveCount = 0;
    }

    private void addTrialCount() {
        trial += 1;
    }
}
