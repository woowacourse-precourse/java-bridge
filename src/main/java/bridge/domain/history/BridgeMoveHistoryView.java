package bridge.domain.history;

import bridge.domain.bridge.BridgeMove;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeMoveHistoryView {
    
    private Map<BridgeMove, List<String>> resultMap;
    
    public BridgeMoveHistoryView(BridgeMoveHistory bridgeMoveHistory) {
        update(bridgeMoveHistory);
    }
    
    public Map<BridgeMove, List<String>> getResultMap() {
        return resultMap;
    }
    
    private static Map<BridgeMove, List<String>> initResultMapBySize(int size) {
        Map<BridgeMove, List<String>> result = new HashMap<>();
        
        for (BridgeMove bridgeMove : BridgeMove.values()) {
            List<String> list = Arrays.asList(new String[size]);
            Collections.fill(list, BridgeMoveResultStatus.NOT_SELECTED.getOutput());
            result.put(bridgeMove, list);
        }
        
        return result;
    }
    
    public void update(BridgeMoveHistory newHistory) {
        resultMap = initResultMapBySize(newHistory.size());
        for (int i = 0; i < newHistory.size(); i++) {
            BridgeMoveResult moveResult = newHistory.getResults().get(i);
            List<String> moveResultTexts = resultMap.get(moveResult.getBridgeMove());
            moveResultTexts.set(i, moveResult.getStatus().getOutput());
        }
    }
}
