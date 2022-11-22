package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static final int BRIDGE_MIN_SIZE = 3;
    public static final int BRIDGE_MAX_SIZE = 20;
    public static final String BRIDGE_SIZE_ERROR = String.format(
            "[ERROR] 다리 길이는 %d부터 %d 사이의 숫자여야 합니다."
            , BRIDGE_MIN_SIZE
            , BRIDGE_MAX_SIZE
    );

    private List<String> bridge;
    private int cur = 0;
    private int tryCount = 0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String icon) {
        if (bridge.get(cur).equals(icon)) {
            cur++;
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        cur = 0;
    }

    public boolean isEnd() {
        return cur == bridge.size();
    }

    public void setBridge(List<String> bridge) throws IllegalArgumentException {
        validateBridge(bridge);
        this.bridge = bridge;
        tryCount++;
    }

    private void validateBridge(List<String> bridge) throws IllegalArgumentException {
        if (bridge.size() < BRIDGE_MIN_SIZE || BRIDGE_MAX_SIZE < bridge.size()) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
        for (String block : bridge) {
            Direction.valueOfIcon(block);
        }
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getCur() {
        return cur;
    }

    public int getTryCount() {
        return tryCount;
    }
}
