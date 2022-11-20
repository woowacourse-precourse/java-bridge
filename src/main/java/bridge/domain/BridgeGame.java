package bridge.domain;

import bridge.domain.bridgeenum.MovePosition;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
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
        MovePosition.validateNextMove(nextPosition); //검증 controller 에서?
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
        return !isGameOver && bridge.hasReachedEnd(currentBoardIndex); //마지막까지 갔지만, 그 칸에서 실패한 경우 테스트 케이스 추가 , 게임 중도 실패한 경우 추가, 끝까지 성공한 경우 추가
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
