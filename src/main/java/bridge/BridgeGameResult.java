package bridge;

import bridge.constant.BridgeChoice;
import bridge.constant.MovingResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeGameResult {
    private Map<String, List<String>> resultMap;
    private List<String> upBridge;
    private List<String> downBridge;
    private boolean Success;

    public BridgeGameResult() {
        resultMap = new HashMap<>();
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
        resultMap.put(BridgeChoice.UP.getDirection(), upBridge);
        resultMap.put(BridgeChoice.DOWN.getDirection(), downBridge);
        Success = true;
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }

    public boolean getSuccess() {
        return Success;
    }

    public void addResult(String movingCommand, String sign) {
        resultMap.get(movingCommand).add(sign);
        for (String key : resultMap.keySet()) {
            if (!key.equals(movingCommand)) {
                resultMap.get(key).add(" ");
            }
        }
        Success = getComparison(sign);
    }

    public boolean getComparison(String sign) {
        return MovingResult.fromSign(sign)
                .getComparison();
    }

    public void clear() {
        upBridge.clear();
        downBridge.clear();
        Success = true;
    }
}
