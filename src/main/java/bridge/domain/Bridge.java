package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private int nowIndex;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.nowIndex = 0;
    }

    public int getNowIndex() {
        return nowIndex;
    }

    public void nowIndexUpdate() {
        this.nowIndex += 1;
    }

    public void resetGame() {
        nowIndex = 0;
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
}
