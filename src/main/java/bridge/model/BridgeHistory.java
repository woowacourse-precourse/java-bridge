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

    public void updateGameState(String command, boolean isSuccess) {
        String alterCommand = LocationTable.getAlternativeKey(command);
        String check = "O";

        if (!isSuccess) check = "X";
        List<String> target = history.getOrDefault(command, new ArrayList<>());
        List<String> another = history.getOrDefault(LocationTable.getAlternativeKey(command), new ArrayList<>());

        target.add(check);
        another.add(" ");

        history.put(command, target);
        history.put(alterCommand, another);
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

}
