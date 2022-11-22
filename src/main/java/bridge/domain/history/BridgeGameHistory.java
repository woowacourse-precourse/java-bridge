package bridge.domain.history;

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
    
    public BridgeMoveHistoryView getMoveHistoryView() {
        return new BridgeMoveHistoryView(moveHistory);
    }
}
