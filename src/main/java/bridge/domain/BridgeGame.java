package bridge.domain;

import bridge.domain.bridgeenum.MovePosition;
import java.util.List;

public class BridgeGame {
    private final Bridge bridge;
    private final MoveResult moveResult;
    private int currentBoardIndex;
    private boolean isGameOver;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.moveResult = new MoveResult();
        initializeGame();
    }

    public void move(String nextPosition) throws IllegalArgumentException {
        MovePosition.validateNextMove(nextPosition);
        boolean isSuccess = bridge.checkMoveSuccess(nextPosition, currentBoardIndex);
        updateGameStatus(nextPosition, isSuccess);
    }

    public void retry() {
        initializeGame();
        moveResult.clearResult();
    }

    public List<List<String>> getCurrentMap() {
        return moveResult.getMap();
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public boolean isGamePass() {
        return !isGameOver && bridge.hasReachedEnd(currentBoardIndex);
    }

    private void initializeGame() {
        this.currentBoardIndex = 0;
        this.isGameOver = false;
    }

    private void updateGameStatus(String position, boolean isSuccess) {
        moveResult.updateMoveResult(isSuccess, position);
        updateGameOverStatus(isSuccess);
        updateBridgeIndex();
    }

    private void updateGameOverStatus(boolean isSuccess) {
        isGameOver = !isSuccess;
    }

    private void updateBridgeIndex() {
        currentBoardIndex += 1;
    }
}
