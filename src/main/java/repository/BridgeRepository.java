package repository;

import constants.BridgeForm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeRepository {
    private List<String> bridge;
    private final List<String> progress = new ArrayList<>();
    private final Map<String, List<String>> result = new HashMap<>();

    public void saveBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void saveProgress(String direction) {
        progress.add(direction);
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public List<String> getProgress() {
        return this.progress;
    }

    public void resetResult() {
        result.clear();
        result.put(BridgeForm.UP.getDirection(), new ArrayList(Collections.nCopies(progress.size(), " ")));
        result.put(BridgeForm.DOWN.getDirection(), new ArrayList(Collections.nCopies(progress.size(), " ")));
    }

    public void saveResult(String direction, int position, String successOrFail) {
        result.get(direction).set(position, successOrFail);
    }

    public Map<String, List<String>> getResult() {
        return this.result;
    }

    public void resetProgress() {
        this.progress.clear();
    }
}
