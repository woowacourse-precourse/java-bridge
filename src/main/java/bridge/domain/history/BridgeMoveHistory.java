package bridge.domain.history;

import java.util.ArrayList;
import java.util.List;

public class BridgeMoveHistory {
    
    private final List<BridgeMoveResult> results = new ArrayList<>();
    
    public BridgeMoveHistory() {
    }
    
    public List<BridgeMoveResult> getResults() {
        return results;
    }
    
    public int size() {
        return results.size();
    }
    
    public void add(BridgeMoveResult result) {
        results.add(result);
    }
    
    public int countResultsBySuccess() {
        return (int) results.stream()
                .filter((bridgeMoveResult -> bridgeMoveResult.getStatus().equals(BridgeMoveResultStatus.SUCCESS)))
                .count();
    }
}
