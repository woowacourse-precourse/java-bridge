package bridge.domain.game;

import bridge.BridgeMove;
import bridge.domain.bridge.Bridge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeGameHistory {
    
    private final Map<Integer, List<BridgeMove>> moveHistories = new HashMap<>();
    private final Bridge bridge;
    
    public BridgeGameHistory(Bridge bridge) {
        this.bridge = bridge;
    }
    
    public void createHistory(Integer tryCount) {
        validateNotExist(tryCount);
        moveHistories.put(tryCount, new ArrayList<>());
    }
    
    public void addMoveHistory(Integer tryCount, BridgeMove move) {
        validateExist(tryCount);
        moveHistories.get(tryCount).add(move);
    }
    
    private List<BridgeMove> getMoveHistoriesByTryCount(Integer tryCount) {
        validateExist(tryCount);
        return moveHistories.get(tryCount);
    }
    
    private void validateNotExist(Integer tryCount) {
        if (moveHistories.get(tryCount) != null) {
            throw new IllegalArgumentException("이미 생성된 History입니다.");
        }
    }
    
    private void validateExist(Integer tryCount) {
        if (moveHistories.get(tryCount) == null) {
            throw new IllegalArgumentException("존재하지 않는 History입니다.");
        }
    }
    
    public int getMoveCount(Integer tryCount) {
        int result = 0;
        List<BridgeMove> histories = getMoveHistoriesByTryCount(tryCount);
        for (; result < histories.size(); result++) {
            if (!bridge.canMoveToPosition(histories.get(result), result)) {
                break;
            }
        }
        return result;
    }
}
