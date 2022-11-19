package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameHistory {

    private List<String> bridgeHistory;
    private int currentIndex;
    private int bridgeSize;

    public BridgeGameHistory(int bridgeSize) {
        this.bridgeHistory = new ArrayList<>();
        this.currentIndex = 0;
        this.bridgeSize = bridgeSize;
    }

    public void addBridgeHistory(String next) {
        bridgeHistory.add(next);
    }

    public int getCurrentIndex() {
        updateCurrentIndex();
        return currentIndex;
    }

    public List<String> getBridgeHistory() {
        return bridgeHistory;
    }

    private void updateCurrentIndex() {
        currentIndex = bridgeHistory.size() - 1;
    }

    public void initBridgeHistory() {
        bridgeHistory = new ArrayList<>();
        currentIndex = 0;
    }

    public boolean isEndGame() {
        if (bridgeHistory.size() == bridgeSize) {
            return true;
        }
        return false;
    }
}
