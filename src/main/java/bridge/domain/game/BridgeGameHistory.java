package bridge.domain.game;

import bridge.BridgeMove;
import bridge.domain.BridgeMoveHistory;
import bridge.domain.bridge.Bridge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeGameHistory {
    
    private final Map<Integer, List<BridgeMoveHistory>> moveHistories = new HashMap<>();
    private final Bridge bridge;
    
    public BridgeGameHistory(Bridge bridge) {
        this.bridge = bridge;
    }
    
    public void createHistory(Integer tryCount) {
        validateNotExist(tryCount);
        moveHistories.put(tryCount, new ArrayList<>());
    }
    
    public void addMoveHistory(Integer tryCount, BridgeMoveHistory moveHistory) {
        validateExist(tryCount);
        moveHistories.get(tryCount).add(moveHistory);
    }
    
    public List<BridgeMoveHistory> getMoveHistoriesByTryCount(Integer tryCount) {
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
        List<BridgeMoveHistory> histories = getMoveHistoriesByTryCount(tryCount);
        return (int) histories.stream().filter(BridgeMoveHistory::isSuccess).count();
    }
    
    public int getFailCount(Integer tryCount) {
        List<BridgeMoveHistory> histories = getMoveHistoriesByTryCount(tryCount);
        return (int) histories.stream().filter((history) -> !history.isSuccess()).count();
    }
    
    public Map<BridgeMove, List<String>> getMoveResultByTryCount(Integer tryCount) {
        List<BridgeMoveHistory> histories = getMoveHistoriesByTryCount(tryCount);
        
        Map<BridgeMove, List<String>> result = BridgeMove.getInitMoveResultByMoves(histories.size());
        updateMoveResultByMoveHistories(result, histories);
        
        return result;
    }
    
    private void updateMoveResultByMoveHistories(Map<BridgeMove, List<String>> moveResults,
            List<BridgeMoveHistory> histories) {
        for (int i = 0; i < histories.size(); i++) {
            BridgeMoveHistory bridgeMoveHistory = histories.get(i);
            List<String> strings = moveResults.get(bridgeMoveHistory.getBridgeMove());
            strings.set(i, bridgeMoveHistory.getMoveResult());
        }
    }
}
