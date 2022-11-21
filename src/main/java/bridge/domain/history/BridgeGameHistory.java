package bridge.domain.history;

import bridge.domain.bridge.BridgeMove;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class BridgeGameHistory {
    
    private final Map<Integer, BridgeMoveHistory> moveHistories = new HashMap<>();
    
    public BridgeGameHistory() {
    }
    
    public void createHistory(Integer tryCount) {
        validateNotExist(tryCount);
        moveHistories.put(tryCount, new BridgeMoveHistory());
    }
    
    public void addMoveResult(Integer tryCount, BridgeMoveResult result) {
        validateExist(tryCount);
        moveHistories.get(tryCount).add(result);
    }
    
    public BridgeMoveHistory getMoveHistory(Integer tryCount) {
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
    
    private List<Entry<Integer, BridgeMoveHistory>> sortBySuccessMoveCount() {
        return moveHistories.entrySet().stream().sorted((e1, e2) -> {
                    
                    int countByE1 = e1.getValue().countResultsBySuccess();
                    int countByE2 = e2.getValue().countResultsBySuccess();
                    if (countByE1 == countByE2) {
                        return e2.getKey() - e1.getKey();
                    }
                    return countByE2 - countByE1;
                })
                .collect(Collectors.toList());
    }
    
    /**
     * @return 최고 기록의 tryCount
     */
    public int getTryCountOfBestRecord() {
        List<Entry<Integer, BridgeMoveHistory>> sortedBySuccessMoveCount = sortBySuccessMoveCount();
        if (sortedBySuccessMoveCount.size() != 0) {
            return sortedBySuccessMoveCount.get(0).getKey();
        }
        return -1;
    }
    
    public Map<BridgeMove, List<String>> getMoveResultByTryCount(Integer tryCount) {
        BridgeMoveHistory history = getMoveHistory(tryCount);
        
        Map<BridgeMove, List<String>> result = BridgeMove.getInitMoveResultByMoves(history.size());
        updateMoveResultByMoveHistories(result, history);
        
        return result;
    }
    
    private void updateMoveResultByMoveHistories(Map<BridgeMove, List<String>> moveResults,
            BridgeMoveHistory history) {
        for (int i = 0; i < history.size(); i++) {
            BridgeMoveResult moveResult = history.getResults().get(i);
            List<String> strings = moveResults.get(moveResult.getBridgeMove());
            strings.set(i, moveResult.getStatus().getOutput());
        }
    }
}
