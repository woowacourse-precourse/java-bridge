package bridge.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private List<String> movePath = new ArrayList<>();
    private int totalCount = 1;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveCommand) {
        movePath.add(moveCommand);
    }

    public boolean checkPossibleMove(int index) {
        if (bridge.get(index).equals(movePath.get(index))) {
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
        addTotalCount();
        movePath.clear();
    }

    private void addTotalCount() {
        this.totalCount++;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getMovePath() {
        return movePath;
    }
}
