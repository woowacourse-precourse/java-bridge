package bridge.model.GameResult;

import bridge.constant.Score;

import java.util.List;


public class Result {

    private Score score;
    private Record record = new Record();

    public void setScore(Score score) {
        this.score = score;
    }

    public String getScoreMessage() {
        return score.getMessage();
    }

    public List<List<String>> getBridgeRecord() {
        return record.getBridgeRecord();
    }

    public void updateBridgeRecord(Score score, String moveDirection) {
        record.updateBridgeRecord(score, moveDirection);
    }

    public void deleteBridgeRecord() {
        record.deleteBridgeRecord();
    }
}