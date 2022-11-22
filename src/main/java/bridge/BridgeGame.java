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

    public boolean checkIfWin() {
        return (selectedPath.size() == bridge.size()
                && checkCurrentStatus());
    }

    public String generateMap() {
        if (selectedPath.isEmpty()) {
            return ("");
        }
        return (generateRow("U") + "\n" + generateRow("D"));
    }

    private String generateRow(String rowIdentifier) {
        List<String> row = new ArrayList<>();
        int size = selectedPath.size();
        for (int i = 0; i < size; i++) {
            row.add(chooseAppropriateOne(rowIdentifier, i));
        }
        return ("[ " + String.join(" | ", row) + " ]");
    }

    private String chooseAppropriateOne(String rowIdentifier, int index) {
        String bridgeOne = bridge.get(index);
        String selectedOne = selectedPath.get(index);
        if (!selectedOne.equals(rowIdentifier)) {
            return (" ");
        }
        if (!selectedOne.equals(bridgeOne)) {
            return ("X");
        }
        return ("O");
    }
}
