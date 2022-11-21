package bridge.domain.game;

import bridge.domain.bridge.BridgeMove;
import bridge.domain.bridge.Bridge;
import bridge.domain.history.BridgeGameHistory;
import bridge.domain.history.BridgeMoveResult;
import bridge.domain.history.BridgeMoveResultStatus;

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
        getHistory().addMoveResult(getTryCount(), new BridgeMoveResult(move, BridgeMoveResultStatus.SUCCESS));
        setCurrentPosition(getCurrentPosition() + 1);
    }
    
    public void fail(BridgeMove move) {
        getHistory().addMoveResult(getTryCount(), new BridgeMoveResult(move, BridgeMoveResultStatus.FAILURE));
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
