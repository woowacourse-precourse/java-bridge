package bridge;

import bridge.domain.Bridge;
import bridge.domain.GameStatus;

public class BridgeGame {

    public boolean move(GameStatus gameStatus, Bridge bridge, String s) {
        if (s.equals("U")) {
            if (bridge.getBridge().get(0).equals(s)) {
                gameStatus.topBridge.add("O");
                gameStatus.bottomBridge.add(" ");
                bridge.getBridge().remove(0);
                return true;
            }
            if (!bridge.getBridge().get(0).equals(s)) {
                gameStatus.topBridge.add("X");
                gameStatus.bottomBridge.add(" ");
            }
        }

        if (s.equals("D")) {
            if (bridge.getBridge().get(0).equals(s)) {
                gameStatus.bottomBridge.add("O");
                gameStatus.topBridge.add(" ");
                bridge.getBridge().remove(0);
                return true;
            }
            if (!bridge.getBridge().get(0).equals(s)) {
                gameStatus.bottomBridge.add("X");
                gameStatus.topBridge.add(" ");
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
