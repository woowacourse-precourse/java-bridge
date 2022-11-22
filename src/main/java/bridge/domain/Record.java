package bridge.domain;

import bridge.utils.enums.MoveFormat;
import bridge.utils.enums.MoveResults;

import java.util.ArrayList;
import java.util.List;

public class Record {
    private final List<String> upBridgeResult;
    private final List<String> downBridgeResult;

    public Record() {
        upBridgeResult = new ArrayList<>();
        downBridgeResult = new ArrayList<>();
    }

    public void write(String move, boolean moveSuccess) {
        String resultString = getResultString(moveSuccess);

        resultRecord(move, resultString);
    }

    public List<String> getRecordedMap() {
        List<String> map = new ArrayList<>();
        map.add(getFormedMap(upBridgeResult));
        map.add(getFormedMap(downBridgeResult));

        return map;
    }

    public void initialize() {
        upBridgeResult.clear();
        downBridgeResult.clear();
    }

    private String getResultString(boolean moveSuccess) {
        if (moveSuccess) {
            return MoveResults.SUCCESS.getValue();
        }
        return MoveResults.FAIL.getValue();
    }

    private void resultRecord(String move, String result) {
        if (MoveFormat.MOVE_UP.isEqual(move)) {
            recordUpBridge(result);
        }

        if (MoveFormat.MOVE_DOWN.isEqual(move)) {
            recordDownBridge(result);
        }
    }

    private void recordUpBridge(String result) {
        upBridgeResult.add(result);
        downBridgeResult.add(MoveResults.NONE.getValue());
    }

    private void recordDownBridge(String result) {
        downBridgeResult.add(result);
        upBridgeResult.add(MoveResults.NONE.getValue());
    }

    private String getFormedMap(List<String> bridgeResult) {
        return String.join("|", bridgeResult);
    }
}
