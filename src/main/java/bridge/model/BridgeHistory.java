package bridge.model;

import bridge.commom.constant.GameState;
import bridge.commom.constant.LocationTable;

import java.util.ArrayList;
import java.util.HashMap;
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
        this.nowStage = 0;
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

    public GameState getProgress() {
        if (isFail()) {
            return GameState.FAIL;
        }
        if (isSuccess()) {
            return GameState.SUCCESS;
        }

        return GameState.RUNNING;
    }

    public void resetHistory() {
        history = new HashMap<>();
        nowStage = 0;
        retry++;
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


    private void addPage(String key, String alterKey, String checkShape) {
        List<String> target = getPages(key);
        List<String> another = getPages(alterKey);

        target.add(checkShape);
        another.add(" ");
        history.put(key, target);
        history.put(alterKey, another);
    }

    private String getCheckShape(boolean isSuccess) {
        if (isSuccess) {
            return "O";
        }

        return "X";
    }

    private List<String> getPages(String key) {
        return history.getOrDefault(key, new ArrayList<>());
    }

    private boolean isSuccess() {
        return getPages("U").size() == bridgeLength;
    }

    private boolean isFail() {
        return getPages("D").contains("X") || getPages("U").contains("X");
    }
}
