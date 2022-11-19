package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final List<String> movingStatus = new ArrayList<>();

    public List<String> getMovingStatus() {
        return movingStatus;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(final List<String> randomBridge, final String moving) {
        saveMovingStatus(randomBridge, moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    private void saveMovingStatus(final List<String> randomBridge, final String moving) {
        if (isCorrectBridge(randomBridge, moving)) {
            movingStatus.add(moving);
        }
        if (!isCorrectBridge(randomBridge, moving)) {
            movingStatus.add(BridgeComponent.FAIL_SIGNATURE);
        }
    }

    private boolean isCorrectBridge(final List<String> randomBridge, final String moving) {
        int firstIndex = 0;
        int lastIndex = movingStatus.size() - 1;
        if (movingStatus.isEmpty()) {
            return compareBridge(randomBridge.get(firstIndex), moving);
        }
        return compareBridge(randomBridge.get(lastIndex), moving);
    }

    private boolean compareBridge(final String bridge, final String moving) {
        return bridge.equals(moving);
    }
}
