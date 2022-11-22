package bridge.domain;

import java.util.List;

public class BridgeGame {
    private final List<String> bridge;
    private int nowIndex;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.nowIndex = 0;
    }

    public int getNowIndex() {
        return nowIndex;
    }

    private int getBridgeIndexOfEnd() {
        return bridge.size() - 1;
    }

    public boolean isEndOfIndex() {
        return nowIndex == getBridgeIndexOfEnd();
    }

    public boolean isCorrectMoveDirection(String moveDirection) {
        return bridge.get(nowIndex).equals(moveDirection);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        this.nowIndex += 1;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        nowIndex = 0;
    }
}

