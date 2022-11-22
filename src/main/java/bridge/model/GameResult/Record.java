package bridge.model.GameResult;

import bridge.constant.Direction;
import bridge.constant.Score;

import java.util.ArrayList;
import java.util.List;

import static bridge.constant.Direction.*;
import static bridge.constant.Score.NONE;

public class Record {

    private List<String> upBridgeRecord;
    private List<String> downBridgeRecord;

    public Record () {
        upBridgeRecord = new ArrayList<>();
        downBridgeRecord = new ArrayList<>();
    }

    public List<List<String>> getBridgeRecord() {
        return List.of(upBridgeRecord, downBridgeRecord);
    }

    public void updateBridgeRecord(Score score, String moveDirection) {
        Direction direction = getDirectionByMessage(moveDirection);

        if (direction == UP) {
            updateUpBridgeScoreMark(score);
            return;
        }
        updateDownBridgeScoreMark(score);
    }

    private void updateUpBridgeScoreMark(Score score) {
        String gameScoreMark = score.getMark();
        String noneScoreMark = NONE.getMark();

        upBridgeRecord.add(gameScoreMark);
        downBridgeRecord.add(noneScoreMark);
    }

    private void updateDownBridgeScoreMark(Score score) {
        String gameScoreMark = score.getMark();
        String noneScoreMark = NONE.getMark();

        downBridgeRecord.add(gameScoreMark);
        upBridgeRecord.add(noneScoreMark);
    }

    public void deleteBridgeRecord() {
        upBridgeRecord = new ArrayList<>();
        downBridgeRecord = new ArrayList<>();
    }
}