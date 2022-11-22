package bridge.domain.game;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.Square;
import bridge.domain.move.MoveResult;


public class BridgeGame {

    private final Bridge bridge;

    private int position;

    private int retryCount;

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

    public boolean isFinalSuccess() {
        return bridge.isEndOfBridge(position);
    }

    @Override
    public String toString() {
        return String.format("현재 위치 : %s, 재시도 횟수 : %d",
                this.position,
                this.retryCount);
    }

    public int getPosition() {
        return position;
    }

    public int getRetryCount() {
        return retryCount;
    }
}
