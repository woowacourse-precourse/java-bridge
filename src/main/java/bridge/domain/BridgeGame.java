package bridge.domain;

import bridge.view.GameSign;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final GameSign gameSign = null;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(List<String> bridge, String direction, int stage) {
        if (bridge.get(stage - 1).equals(direction)) {
            return GameSign.MOVING_SUCCESS.getMessage();
        }
        return GameSign.MOVING_FAIL.getMessage();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retryOrQuit) {
        return retryOrQuit.equals(GameSign.RETRY.getMessage());
    }
}
