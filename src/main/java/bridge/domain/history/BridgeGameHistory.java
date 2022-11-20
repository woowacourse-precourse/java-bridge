package bridge.domain.history;

import bridge.domain.bridge.BridgeMove;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class BridgeGameHistory {
    
    private final Map<Integer, List<BridgeMoveHistory>> moveHistories = new HashMap<>();
    
    public BridgeGameHistory() {
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
    
    private List<Entry<Integer, List<BridgeMoveHistory>>> sortBySuccessMoveCount() {
        return moveHistories.entrySet().stream().sorted((e1, e2) -> {
                    int countByE1 = countSuccessMoveHistories(e1.getValue());
                    int countByE2 = countSuccessMoveHistories(e2.getValue());
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
        List<Entry<Integer, List<BridgeMoveHistory>>> sortedBySuccessMoveCount = sortBySuccessMoveCount();
        if (sortedBySuccessMoveCount.size() != 0) {
            return sortedBySuccessMoveCount.get(0).getKey();
        }
        return -1;
    }
    
    private int countSuccessMoveHistories(List<BridgeMoveHistory> moveHistories) {
        return (int) moveHistories.stream().filter(BridgeMoveHistory::isSuccess).count();
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
