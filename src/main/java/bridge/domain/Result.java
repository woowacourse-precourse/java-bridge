package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private static final String SUCCESS = " O ";
    private static final String FAIL = " X ";
    private static final String NONE = "   ";
    private List<String> upBridgeResult;
    private List<String> downBridgeResult;

    public Result() {
        upBridgeResult = new ArrayList<>();
        downBridgeResult = new ArrayList<>();
    }

    public void write(String move, boolean moveSuccess) {
        String resultString = getResultString(moveSuccess);

        resultRecord(move, resultString);
    }

    private String getResultString(boolean moveSuccess) {
        if (moveSuccess) {
            return SUCCESS;
        }
        return FAIL;
    }

    private void resultRecord(String move, String result) {
        if (move.equals("U")) {
            recordUpBridge(result);
        }

        if (move.equals("D")) {
            recordDownBridge(result);
        }
    }

    private void recordUpBridge(String result) {
        upBridgeResult.add(result);
        downBridgeResult.add(NONE);
    }

    private void recordDownBridge(String result) {
        downBridgeResult.add(result);
        upBridgeResult.add(NONE);
    }
}
