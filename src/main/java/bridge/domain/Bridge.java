package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private int nowIndex;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.nowIndex = 1;
    }

    public int getNowIndex() {
        return nowIndex;
    }

    public int getBridgeSize() {
        return this.bridge.size();
    }

    public void setNowIndex(int index) {
        this.nowIndex = index;
    }

    public void nowIndexUpdate() {
        setNowIndex(this.nowIndex + 1);
    }

    public void resetGame() {
        setNowIndex(1);
    }

    public List<String> getBridge() {
        return bridge;
    }
}
