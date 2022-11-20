package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(final Bridge bridge, final List<String> movings) {
        int index = movings.size() - 1;

        if (movings.get(index).equals("U")) {
            return compareWhenMovingEqualsU(bridge, index);
        }
        if (movings.get(index).equals("D")) {
            return compareWhenMovingEqualsD(bridge, index);
        }
        return null;
    }

    public String compareWhenMovingEqualsU(final Bridge bridge, final int index) {
        if (bridge.hasUAtIndex(index)) {
            return "O";
        }
        return "X";
    }

    public String compareWhenMovingEqualsD(final Bridge bridge, final int index) {
        if (!bridge.hasUAtIndex(index)) {
            return "O";
        }
        return "X";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
