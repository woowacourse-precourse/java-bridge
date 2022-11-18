package bridge.domain.game;

import bridge.BridgeMove;
import bridge.domain.bridge.Bridge;

public class BridgeGame {
    
    private final Bridge bridge;
    private Integer currentPosition = -1;
    private Integer tryCount = 1;
    
    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }
    
    public Bridge getBridge() {
        return bridge;
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
    
    public void move() {
        if (isReachedLastPosition()) return;
        setCurrentPosition(getCurrentPosition() + 1);
    }
    
    public void retry() {
        setCurrentPosition(-1);
        setTryCount(getTryCount() + 1);
    }
    
    public boolean canMoveToNextPosition(BridgeMove move) {
        return getBridge().canMoveToPosition(move, getNextPosition());
    }
}
