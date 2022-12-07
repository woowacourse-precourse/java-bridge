package bridge.model;

import bridge.constant.Score;

import static bridge.constant.Score.FAIL;
import static bridge.constant.Score.PASS;

public class Move {

    private String moveDirection;
    private Score score;

    public void setMoveDirection(String moveDirection) {
        this.moveDirection = moveDirection;
    }

    public String getMoveDirection() {
        return moveDirection;
    }

    public Score judge(BridgePosition bridgePosition) {
        if (bridgePosition.isFail(moveDirection)) {
            this.score = FAIL;
            return score;
        }
        this.score = PASS;
        return score;
    }

    public String getScoreMessage() {
        return score.getMessage();
    }
}