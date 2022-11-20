package bridge.model;

import bridge.commom.constant.LocationTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BridgeHistory {
    private final int bridgeLength;
    private Map<String, List<String>> history;
    private int retry;
    private int nowStage;

    public BridgeHistory(Map<String, List<String>> history, int bridgeLength) {
        this.bridgeLength = bridgeLength;
        this.history = history;
        this.retry = 1;
    }

    public void getProgress() {

    }

    public Map<String, List<String>> getHistory() {
        return history;
    }

    public int getRetry() {
        return retry;
    }

    public int getNowStage() {
        return nowStage;
    }

    private String getCheckShape(boolean isSuccess) {
        if (isSuccess) return "O";
        return "X";
    }

    public void updateGameState(String command, boolean isSuccess) {
        updateHistory(command, isSuccess);
        nowStage++;
    }

    private void updateHistory(String command, boolean isSuccess) {
        String alterCommand = LocationTable.getAlternativeKey(command);
        String checkShape = getCheckShape(isSuccess);
        addPage(command, alterCommand, checkShape);
    }

    private void addPage(String command, String alterCommand, String checkShape) {
        List<String> target = history.getOrDefault(command, new ArrayList<>());
        List<String> another = history.getOrDefault(alterCommand, new ArrayList<>());

        target.add(checkShape);
        another.add(" ");
        history.put(command, target);
        history.put(alterCommand, another);
    }
}
