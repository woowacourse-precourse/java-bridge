package bridge.domain.game;

import bridge.domain.bridge.BridgeMove;
import bridge.domain.bridge.Bridge;
import bridge.domain.history.BridgeGameHistory;
import bridge.domain.history.BridgeMoveResult;
import bridge.domain.history.BridgeMoveResultStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BridgeGame {
    
    private final Bridge bridge;
    private final List<BridgeGameHistory> histories;
    private BridgeGameStatus status;
    private Integer currentPosition = -1;
    private Integer tryCount = 1;
    
    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.histories = new ArrayList<>();
        addHistory();
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
    
    private int getHistoryIndex(Integer tryCount) {
        return tryCount - 1;
    }
    
    private void addHistory() {
        histories.add(new BridgeGameHistory(getTryCount()));
    }
    
    public BridgeGameStatus getStatus() {
        return status;
    }
    
    public void setStatus(BridgeGameStatus status) {
        this.status = status;
    }
    
    public BridgeGameHistory getCurrentHistory() {
        return histories.get(getHistoryIndex(getTryCount()));
    }
    
    public void move(BridgeMove move) {
        if (isReachedLastPosition()) {
            return;
        }
        getCurrentHistory().addMoveResult(new BridgeMoveResult(move, BridgeMoveResultStatus.SUCCESS));
        setCurrentPosition(getCurrentPosition() + 1);
    }
    
    public void fail(BridgeMove move) {
        getCurrentHistory().addMoveResult(new BridgeMoveResult(move, BridgeMoveResultStatus.FAILURE));
    }
    
    public void retry() {
        setCurrentPosition(-1);
        setTryCount(getTryCount() + 1);
        addHistory();
    }
    
    public boolean canMoveToNextPosition(BridgeMove move) {
        return getBridge().canMoveToPosition(move, getNextPosition());
    }
    
    public Optional<BridgeGameHistory> getHistoryOfBestRecord() {
        List<BridgeGameHistory> cloneHistories = new ArrayList<>(List.copyOf(histories));
        Collections.sort(cloneHistories);
        
        if (cloneHistories.size() != 0) {
            return Optional.of(cloneHistories.get(0));
        }
        
        return Optional.empty();
    }
}
