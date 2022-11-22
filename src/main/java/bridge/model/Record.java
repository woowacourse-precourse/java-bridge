package bridge.model;

import bridge.constant.Direction;
import bridge.constant.Score;

import java.util.ArrayList;
import java.util.List;

import static bridge.constant.Direction.*;
import static bridge.constant.Score.NONE;

public class Record {

    private List<String> upBridgeRecord = new ArrayList<>();
    private List<String> downBridgeRecord = new ArrayList<>();

    public List<List<String>> getBridgeRecord() {
        return List.of(upBridgeRecord, downBridgeRecord);
    }

    public void updateBridgeRecord(Score score, String moveDirection) {
        List<String> selectedDirection = getSelectBridge(moveDirection);
        String gameRecord = score.getMark();
        selectedDirection.add(gameRecord);

        List<String> unSelectedDirection = getUnSelectedBridge();
        String noneRecord = NONE.getMark();
        unSelectedDirection.add(noneRecord);
    }

    private List<String> getSelectBridge(String moveDirection) {
        Direction direction = getDirectionByMessage(moveDirection);

        if (direction == UP) {
            return upBridgeRecord;
        }
        return downBridgeRecord;
    }

    private List<String> getUnSelectedBridge() {
        int upBridgeSize = upBridgeRecord.size();
        int downBridgeSize = downBridgeRecord.size();

        if (downBridgeSize < upBridgeSize) {
            return downBridgeRecord;
        }
        return upBridgeRecord;
    }

    public void deleteBridgeRecord() {
        upBridgeRecord = new ArrayList<>();
        downBridgeRecord = new ArrayList<>();
    }
}