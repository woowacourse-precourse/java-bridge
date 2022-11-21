package bridge.model;

import bridge.commom.constant.GameState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bridge.commom.constant.GameCommand.*;
import static bridge.commom.constant.MarkShape.*;
import static bridge.commom.constant.LocationTable.getAlternativeKey;

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
        resetMap();
        resetStage();
        increaseRetryCount();
    }

    public void updateGameState(String command, boolean isSuccess) {
        updateHistory(command, isSuccess);
        increaseStageCount();
    }

    private void updateHistory(String command, boolean isSuccess) {
        String alterCommand = getAlternativeKey(command);
        String checkShape = getCheckShape(isSuccess);
        addPage(command, alterCommand, checkShape);
    }

    private void addPage(String key, String alterKey, String checkShape) {
        List<String> targetPages = getPages(key);
        List<String> anotherPages = getPages(alterKey);

        markInPage(checkShape, targetPages, anotherPages);
        history.put(key, targetPages);
        history.put(alterKey, anotherPages);
    }

    private void markInPage(String checkShape, List<String> target, List<String> another) {
        target.add(checkShape);
        another.add(EMPTY_MARK);
    }

    private String getCheckShape(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS_MARK;
        }
        return FAIL_MARK;
    }

    private List<String> getPages(String key) {
        return history.getOrDefault(key, new ArrayList<>());
    }

    private boolean isSuccess() {
        return getPages(UPPER_COMMAND).size() == bridgeLength;
    }

    private boolean isFail() {
        return (getPages(DOWN_COMMAND).contains(FAIL_MARK) ||
                getPages(UPPER_COMMAND).contains(FAIL_MARK));
    }

    private void resetMap() {
        history = new HashMap<>();
    }

    private void resetStage() {
        nowStage = 0;
    }

    private void increaseRetryCount() {
        retry++;
    }

    private void increaseStageCount() {
        nowStage++;
    }
}
