package bridge.domain;

import java.util.HashMap;
import java.util.Map;

public class BridgeGameResult {
    private final Map<String, String> result;

    public BridgeGameResult() {
        this.result = new HashMap<>();
    }

    public void putMovingResult(String moving, String movingResult) {
        result.put(moving, movingResult);
    }

    public boolean isSuccess(int bridgeSize) {
        return result.size() == bridgeSize;
    }

    public Map<String, String> getResult() {
        return result;
    }

    public void clearResult() {
        result.clear();
    }
}
