package bridge.domain;

import java.util.List;

public class Bridge {
    private List<String> bridge;
    private int nowIndex;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.nowIndex = 0;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getNowIndex() {
        return this.nowIndex;
    }

    public boolean isSameValueOfComputerAndUser(String move) {
        return bridge.get(this.nowIndex).equals(move);
    }

    public boolean isEndPoint() {
        return bridge.size() - 1 == nowIndex;
    }

    public void nextIndex() {
        this.nowIndex += 1;
    }

    public void resetIndex() {
        nowIndex = 0;
    }
}
