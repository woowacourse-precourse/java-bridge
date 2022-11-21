package bridge.domain;

import bridge.utils.Converter;
import bridge.utils.MoveResults;

import java.util.ArrayList;
import java.util.List;

public class Record {
    private List<String> upBridgeResult;
    private List<String> downBridgeResult;
    private int tryCount = 1;

    public Record() {
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

    public void initialize() {
        upBridgeResult = new ArrayList<>();
        downBridgeResult = new ArrayList<>();
    }

    public void plusTryCount() {
        tryCount += 1;
    }

    private String getResultString(boolean moveSuccess) {
        if (moveSuccess) {
            return MoveResults.SUCCESS.getValue();
        }
        return MoveResults.FAIL.getValue();
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
        downBridgeResult.add(MoveResults.NONE.getValue());
    }

    private void recordDownBridge(String result) {
        downBridgeResult.add(result);
        upBridgeResult.add(MoveResults.NONE.getValue());
    }

    private String getResultMessage(List<String> bridgeResult) {
        return String.join("|", bridgeResult);
    }

    private String getWinResult() {
        if (isWin()) {
            return "성공";
        }

        return "실패";
    }

    private boolean isWin() {
        int lastIndex = upBridgeResult.size() - 1;
        String upLastValue = upBridgeResult.get(lastIndex);
        String downLastValue = downBridgeResult.get(lastIndex);

        return MoveResults.SUCCESS.isEqualValue(upLastValue) || MoveResults.SUCCESS.isEqualValue(downLastValue);
    }
}
