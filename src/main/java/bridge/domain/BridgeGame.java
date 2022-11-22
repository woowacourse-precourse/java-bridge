package bridge.domain;

import bridge.exception.CannotCrossBridgeException;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;

    private List<Cell> bridgeStatus;
    private int attemptCount;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.bridgeStatus = new ArrayList<>();
        this.attemptCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param direction
     */
    public void move(String direction, int bridgeIndex) {
        if (!compareDirection(direction, bridgeIndex)) {
            bridgeStatus.add(new Cell("X", direction));
            throw new CannotCrossBridgeException();
        }
        bridgeStatus.add(new Cell("O", direction));
    }

    public boolean compareDirection(String direction, int bridgeIndex) {
        return direction.equals(bridge.get(bridgeIndex));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgeStatus = new ArrayList<>();
        attemptCount++;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<Cell> getBridgeStatus() {
        return bridgeStatus;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
