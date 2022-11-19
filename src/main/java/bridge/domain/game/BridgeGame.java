package bridge.domain.game;

import bridge.BridgeMove;
import bridge.domain.BridgeMoveHistory;
import bridge.domain.bridge.Bridge;

public class BridgeGame {
    
    private final Bridge bridge;
    private final BridgeGameHistory history;
    private Integer currentPosition = -1;
    private Integer tryCount = 1;
    
    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.history = new BridgeGameHistory();
        history.createHistory(tryCount);
    }
    
    public Bridge getBridge() {
        return bridge;
    }
    
    public BridgeGameHistory getHistory() {
        return history;
    }
    
    public Integer getCurrentPosition() {
        return currentPosition;
    }
    
    public void setCurrentPosition(Integer currentPosition) {
        this.currentPosition = currentPosition;
    }
    
    public Integer getTryCount() {
        return tryCount;
    }
    
    public void setTryCount(Integer tryCount) {
        this.tryCount = tryCount;
    }
    
    private int getNextPosition() {
        return getCurrentPosition() + 1;
    }
    
    public boolean isReachedLastPosition() {
        return getBridge().size() - 1 <= getCurrentPosition();
    }
    
    public void move(BridgeMove move) {
        if (isReachedLastPosition()) return;
        getHistory().addMoveHistory(getTryCount(), new BridgeMoveHistory(move, true));
        setCurrentPosition(getCurrentPosition() + 1);
    }
    
    public void fail(BridgeMove move) {
        getHistory().addMoveHistory(getTryCount(), new BridgeMoveHistory(move, false));
    }
    
    public void retry() {
        setCurrentPosition(-1);
        setTryCount(getTryCount() + 1);
        getHistory().createHistory(getTryCount());
    }
    
    public boolean canMoveToNextPosition(BridgeMove move) {
        return getBridge().canMoveToPosition(move, getNextPosition());
    }
}
