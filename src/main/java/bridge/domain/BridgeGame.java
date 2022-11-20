package bridge.domain;

import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final Bridge attempts;
    private final TryCount tryCount;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.attempts = new Bridge();
        this.tryCount = new TryCount();
    }

    public BridgeGame(Bridge bridge, TryCount tryCount) {
        this.bridge = bridge;
        this.attempts = new Bridge();
        this.tryCount = tryCount;
    }

    public void move(BridgeShape moveBridgeShape) {
        attempts.connect(moveBridgeShape);
    }

    public BridgeGame retry() {
        return new BridgeGame(bridge, tryCount.plusOne());
    }

    public BridgeGameResult result() {
        return bridge.compare(attempts);
    }

    public boolean isNotEnd() {
        return !bridge.sizeEqual(attempts);
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
        return Objects.equals(bridge, that.bridge) && Objects.equals(attempts, that.attempts)
                && Objects.equals(tryCount, that.tryCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridge, attempts, tryCount);
    }
}
