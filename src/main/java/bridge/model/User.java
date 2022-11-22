package bridge.model;

import bridge.constant.Score;

public class User {

    private String moveDirection;
    private Score score;

    public void setMoveDirection(String moveDirection) {
        this.moveDirection = moveDirection;
    }

    public String getMoveDirection() {
        return moveDirection;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getScoreMessage() {
        return score.getMessage();
    }
}