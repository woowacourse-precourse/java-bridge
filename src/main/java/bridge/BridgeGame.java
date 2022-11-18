package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final int NUMBER_OF_BRIDGE = 2;
    private List<String> bridge;
    private int currentStage = 0;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String input) {
        if (bridge.get(currentStage).equals(input))
        {
            currentStage++;
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
        bridge = null;
        currentStage = 0;
    }

    @Override
    public String toString() {
        String str = "[ ";
        for (BridgeStatus bridgeStatus : BridgeStatus.values()) {
            for (int idx = 0; idx < bridge.size(); idx++) {
                str = addOorSpace(str, bridgeStatus, idx);
                str = checkLast(str, idx);
            }
            str += "]\n";
        }
        return str;
    }

    private String checkLast(String str, int idx) {
        if (idx != bridge.size() - 1) {
            str += "| ";
        }
        return str;
    }

    private String addOorSpace(String str, BridgeStatus bridgeStatus, int idx) {
        if (bridge.get(idx).equals(bridgeStatus.getName())) {
            str += "O ";
            return str;
        }
        str += "  ";
        return str;
    }
}
