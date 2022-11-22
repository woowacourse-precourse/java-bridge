package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private int currentBlock;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.currentBlock = 0;
    }

    public int getCurrentBlock() {
        return currentBlock;
    }

    public void updateCurrentBlock() {
        currentBlock += 1;
    }
}
