package bridge.domain;

import bridge.utils.Converter;

public class User {
    private int moveCount;
    private int trial;

    public User() {
        moveCount = 0;
        trial = 1;
    }

    public void move() {
        moveCount += 1;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getTrial() {
        return Converter.toStringFromInt(trial);
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
