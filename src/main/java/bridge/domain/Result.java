package bridge.domain;

import bridge.utils.Converter;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private static final String SUCCESS = " O ";
    private static final String FAIL = " X ";
    private static final String NONE = "   ";
    private List<String> upBridgeResult;
    private List<String> downBridgeResult;
    private int tryCount;

    public Result() {
        upBridgeResult = new ArrayList<>();
        downBridgeResult = new ArrayList<>();
    }

    public void write(String move, boolean moveSuccess) {
        String resultString = getResultString(moveSuccess);

        resultRecord(move, resultString);
    }

    public List<String> getResult() {
        List<String> results = new ArrayList<>();
        results.add(getResultMessage(upBridgeResult));
        results.add(getResultMessage(downBridgeResult));

        return results;
    }

    public List<String> getFinalResultToString() {
        String winning = getWinResult();
        String tryCount = Converter.toStringFromInt(this.tryCount);

        return List.of(winning, tryCount);
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

    private String getResultMessage(List<String> bridgeResult) {
        return String.join("|", bridgeResult);
    }

    private String getWinResult() {
        int lastIndex = upBridgeResult.size() - 1;
        String upLastValue = upBridgeResult.get(lastIndex);
        String downLastValue = downBridgeResult.get(lastIndex);

        if (upLastValue.equals(SUCCESS) || downLastValue.equals(SUCCESS)) {
            return "성공";
        }
        return "실패";
    }
}
