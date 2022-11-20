package bridge;

import bridge.domain.Bridge;
import bridge.domain.User;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(User user, Bridge bridge, String s) {
        if (s.equals("U")) {
            if (bridge.getBridge().get(0).equals(s)) {
                user.topBridge.add("O");
                user.bottomBridge.add(" ");
                bridge.getBridge().remove(0);
                return true;
            }
            if (!bridge.getBridge().get(0).equals(s)) {
                user.topBridge.add("X");
                user.bottomBridge.add(" ");
            }
        }

        if (s.equals("D")) {
            if (bridge.getBridge().get(0).equals(s)) {
                user.bottomBridge.add("O");
                user.topBridge.add(" ");
                bridge.getBridge().remove(0);
                return true;
            }
            if (!bridge.getBridge().get(0).equals(s)) {
                user.bottomBridge.add("X");
                user.topBridge.add(" ");
            }
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
