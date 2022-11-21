package bridge.domain;

import bridge.domain.bridgeenum.MovePosition;
import bridge.domain.bridgeenum.Restart;
import java.util.List;

public class BridgeGame {
    private final Bridge bridge;
    private final MoveResult moveResult;
    private boolean isGameOver;
    private boolean isPlaying;
    private int tryCount;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.moveResult = new MoveResult();
        this.tryCount = 0;
        this.isPlaying = true;
        initializeGame();
    }

    public void move(String nextPosition) throws IllegalArgumentException {
        MovePosition.validateNextMove(nextPosition);
        boolean isSuccess = bridge.checkMoveSuccess(nextPosition, moveResult.getNextMoveIndex());
        updateGameStatus(nextPosition, isSuccess);
    }

    public void retry(String command) throws IllegalArgumentException {
        isPlaying = Restart.isRestart(command);
        if (isPlaying) {
            initializeGame();
        }
    }

    public List<List<String>> getCurrentMap() {
        return moveResult.getMap();
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isGameOver() {
        if (isGameOver) {
            return true;
        }
        if (isGamePass()) {
            isPlaying = false;
        }
        return false;
    }

    public boolean isGamePlaying() {
        return isPlaying;
    }

    public boolean isGamePass() {
        return !isGameOver && bridge.hasReachedEnd(moveResult.getNextMoveIndex());
    }

    private void initializeGame() {
        this.isGameOver = false;
        this.tryCount += 1;
        moveResult.clearResult();
    }

    private void updateGameStatus(String position, boolean isSuccess) {
        moveResult.updateMoveResult(isSuccess, position);
        updateGameOverStatus(isSuccess);
    }

    private void updateGameOverStatus(boolean isSuccess) {
        isGameOver = !isSuccess;
        isPlaying = isSuccess;
    }
}
