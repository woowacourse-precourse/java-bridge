package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeGameResult {
    private Map<String, List<String>> resultMap;
    private List<String> upBridge;
    private List<String> downBridge;

    public BridgeGameResult() {
        resultMap = new HashMap<>();
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
        resultMap.put("U", upBridge);
        resultMap.put("D", downBridge);
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }

    public void addResult(String movingCommand, String sign) {
        resultMap.get(movingCommand).add(sign);
        for (String key : resultMap.keySet()) {
            if (!key.equals(movingCommand)) {
                resultMap.get(key).add(" ");
            }
        }
    }

//    public int getNumber(String direction) {
//        return BridgeChoice.fromSign(direction)
//                .getNumber();
//    }
}
