package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridge;
    private final List<Boolean> results = new ArrayList<>();

    private int tryCount = 1;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void compareWithBridge(String input) {
        boolean result = bridge.get(results.size()).equals(input);
        results.add(result);
    }

    public boolean isFalseInResults() {
        for (Boolean result : results) {
            if(!result)
                return true;
        }
        return false;
    }

    public void restartBridge() {
        results.clear();
    }

    public void plusTryCount() {
        tryCount++;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<Boolean> getResults() {
        return results;
    }

    public int getTryCount() {
        return tryCount;
    }
}
