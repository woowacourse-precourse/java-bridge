package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private List<String> selectedPath;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        selectedPath = new ArrayList<>();
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String selected) {
        selectedPath.add(selected);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    private boolean isLastElementsSame() {
        int lastIndex = selectedPath.size() - 1;
        String currentBridge = bridge.get(lastIndex);
        String currentSelected = selectedPath.get(lastIndex);
        return (currentBridge.equals(currentSelected));
    }

    public boolean checkCurrentStatus() {
        return (selectedPath.isEmpty() || isLastElementsSame());
    }
}
