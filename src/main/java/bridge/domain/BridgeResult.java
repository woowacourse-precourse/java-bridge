package bridge.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class BridgeResult {
    private final Map<Square, MoveResult> bridgeResult;

    public BridgeResult() {
        bridgeResult = new LinkedHashMap<>();
    }

    public void updateResult(Square square, boolean result) {
        bridgeResult.put(square, MoveResult.of(result));
    }
}
