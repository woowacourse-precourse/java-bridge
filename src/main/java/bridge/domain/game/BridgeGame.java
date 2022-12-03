package bridge.domain.game;

import bridge.constant.Bridge;
import bridge.constant.Bridge.GameConstants;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final List<String> movings;
    private int numberOfAttempts;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.movings = new ArrayList<>(bridge.size());
        this.numberOfAttempts = Bridge.GameConstants.INITIAL_VALUE_OF_ATTEMPTS_NUMBER;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(final String direction) {
        movings.add(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(final BridgeMap bridgeMap) {
        movings.clear();
        bridgeMap.clear();
        numberOfAttempts++;
    }

    public boolean over() {
        if (movings.isEmpty()) {
            return false;
        }
        int movingCount = movings.size() - GameConstants.INDEX_REVISION_NUMBER;
        return !movings.get(movingCount).equals(bridge.get(movingCount));
    }

    public boolean inProgress() {
        return !(over() || success());
    }

    public boolean success() {
        return bridge.size() == movings.size() && !over();
    }
}
