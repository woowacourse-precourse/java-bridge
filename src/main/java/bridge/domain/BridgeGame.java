package bridge.domain;

import bridge.domain.bridgeenum.MoveCondition;
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

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String nextPosition) throws IllegalArgumentException {
        MoveCondition.validateNextMove(nextPosition);
        boolean isSuccess = bridge.checkMoveSuccess(nextPosition, currentBoardIndex); //여기서 연산 하고, bridgeGame 에서 다시 그 결과에 따라 이동 내역 업데이트
        updateGameStatus(nextPosition, isSuccess);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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
        return bridge.hasReachedEnd(currentBoardIndex);
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
