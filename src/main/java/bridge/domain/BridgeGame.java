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

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(BridgeShape moveBridgeShape) {
        attempts.connect(moveBridgeShape);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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
