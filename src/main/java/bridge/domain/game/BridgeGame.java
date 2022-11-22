package bridge.domain.game;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.Square;
import bridge.domain.move.MoveResult;


public class BridgeGame {

    private GameStatus gameStatus = GameStatus.PROGRESS;

    private int position;

    private int retryCount;

    private final Bridge bridge;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        retryCount = 1;
    }

    public SquareResult move(Square userMove) {
        boolean movable = bridge.canMoveForward(userMove, position);
        if (movable) {
            position ++;
        }
        return new SquareResult(userMove, MoveResult.of(movable));
    }

    public void retry() {
        position = 0;
        retryCount++;
    }

    public boolean isGameFinalSuccess() {
        return bridge.isEndOfBridge(position);
    }

    public boolean isGameInProgress() {
        return gameStatus.equals(GameStatus.PROGRESS);
    }

    public void exitGame() {
        gameStatus = GameStatus.EXIT;
    }

    public int getPosition() {
        return position;
    }

    public int getRetryCount() {
        return retryCount;
    }

    @Override
    public String toString() {
        return String.format("상태 : %s, 현재 위치 : %s, 재시도 횟수 : %d",
                this.gameStatus.name(),
                this.position,
                this.retryCount);
    }
}
