package bridge.domain.history;

import bridge.domain.bridge.BridgeMove;
import java.util.List;
import java.util.Map;

public class BridgeGameHistory implements Comparable<BridgeGameHistory> {
    private final Integer tryCount;
    private final BridgeMoveHistory moveHistory = new BridgeMoveHistory();
    
    public BridgeGameHistory(Integer tryCount) {
        this.tryCount = tryCount;
    }
    
    public Integer getTryCount() {
        return tryCount;
    }
    
    public void addMoveResult(BridgeMoveResult result) {
        moveHistory.add(result);
    }
    
    @Override
    public int compareTo(BridgeGameHistory history) {
        int countByFirst = this.moveHistory.countResultsBySuccess();
        int countBySecond = history.moveHistory.countResultsBySuccess();
        if (countByFirst == countBySecond) {
            return  history.tryCount - this.tryCount;
        }
        return  countBySecond - countByFirst;
    }
    
    public Map<BridgeMove, List<String>> getMoveResultMap() {
        Map<BridgeMove, List<String>> result = BridgeMove.getInitMoveResultByMoves(moveHistory.size());
        updateMoveResultMapByMoveHistories(result, moveHistory);
        
        return result;
    }
    
    private void updateMoveResultMapByMoveHistories(Map<BridgeMove, List<String>> moveResults,
            BridgeMoveHistory history) {
        for (int i = 0; i < history.size(); i++) {
            BridgeMoveResult moveResult = history.getResults().get(i);
            List<String> strings = moveResults.get(moveResult.getBridgeMove());
            strings.set(i, moveResult.getStatus().getOutput());
        }
    }
}
