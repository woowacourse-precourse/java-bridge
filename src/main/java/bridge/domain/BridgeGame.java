package bridge.domain;

import bridge.exception.domain.CanNotMoveException;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final Bridge playerMove;
    private final TryCount tryCount;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.playerMove = new Bridge();
        this.tryCount = new TryCount();
    }

    public BridgeGame(Bridge bridge, TryCount tryCount) {
        this.bridge = bridge;
        this.playerMove = new Bridge();
        this.tryCount = tryCount;
    }

    public void move(BridgeShape moveBridgeShape) {
        validateCanMove();

        this.playerMove.connect(moveBridgeShape);
    }

    private void validateCanMove() {
        if (!this.bridge.isCanMove(this.playerMove)) {
            throw new CanNotMoveException();
        }
    }

    public BridgeGame retry() {
        return new BridgeGame(this.bridge, this.tryCount.plusOne());
    }

    public BridgeGameResult result() {
        return this.bridge.compare(this.playerMove);
    }

    public boolean isNotEnd() {
        return !this.bridge.sizeEqual(this.playerMove);
    }

    public TryCount tryCount() {
        return this.tryCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BridgeGame that = (BridgeGame) o;
        return Objects.equals(this.bridge, that.bridge) && Objects.equals(this.playerMove, that.playerMove)
                && Objects.equals(this.tryCount, that.tryCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.bridge, this.playerMove, this.tryCount);
    }
}
