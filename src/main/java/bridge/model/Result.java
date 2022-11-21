package bridge.model;

import bridge.constant.Score;

public class Result {

    private Score score;
    private int tryCount = 1;

    public void addTryCount() {
        tryCount +=1;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getScoreMessage() {
        return score.getMessage();
    }
}