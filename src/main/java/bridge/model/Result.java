package bridge.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final List<List<String>> resultBridges = new ArrayList<>();
    private final Map<Boolean, String> ox = new HashMap<>();
    private int tryCount = 1;
    private boolean success = true;

    public Result() {
        initialize();
        ox.put(true, "O");
        ox.put(false, "X");
    }

    public void initialize() {
        resultBridges.clear();
        List<String> upperBridge = new ArrayList<>();
        List<String> lowerBridge = new ArrayList<>();
        resultBridges.add(upperBridge);
        resultBridges.add(lowerBridge);
    }

    public int getTryCount() {
        return tryCount;
    }

    public void increaseTryCount() {
        tryCount++;
    }
}
