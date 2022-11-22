package bridge.model.GameResult;

import bridge.constant.Score;

import java.util.List;

public class Result {

    private int tryCount;
    private Record record;

    public Result() {
        tryCount = 1;
        record = new Record();
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

    public void addTryCount() {
        tryCount +=1;
    }

    public int getTryCount() {
        return tryCount;
    }
}