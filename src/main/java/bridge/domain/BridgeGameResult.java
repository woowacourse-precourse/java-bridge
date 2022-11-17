package bridge.domain;

import java.util.HashMap;
import java.util.Map;

public class BridgeGameResult {
    private final Map<String, String> results;

    public BridgeGameResult() {
        this.results = new HashMap<>();
    }

    public void putResult(String moving, String result) {
        results.put(moving, result);
    }

    public Map<String, String> getResult() {
        return results;
    }
}
