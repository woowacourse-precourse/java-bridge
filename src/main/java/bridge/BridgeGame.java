package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private int position;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Boolean move(String direction, int position) {
        this.position = position;
        if (direction.equals(Bridge.UPPER_BRIDGE.getDirection())) {
            return checkUpper();
        }
        if (direction.equals(Bridge.LOWER_BRIDGE.getDirection())) {
            return checkLower();
        }
        return null;
    }

    private boolean checkUpper() {
        return bridge.get(position).equals(Bridge.UPPER_BRIDGE.getDirection());
    }

    private boolean checkLower() {
        return !bridge.get(position).equals(Bridge.LOWER_BRIDGE.getDirection());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
