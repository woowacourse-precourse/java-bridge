package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final List<String> resultBridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        resultBridge = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int index, String block) {
        if (bridge.get(index).equals(block)) {
            resultBridge.add("O");
            return true;
        }
        resultBridge.add("X");
        return false;
    }

    public void retry() {
        resultBridge.clear();
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public int getResultBridgeSize() {
        return resultBridge.size();
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getResultBridge() {
        return resultBridge;
    }
}