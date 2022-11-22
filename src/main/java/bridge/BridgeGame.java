package bridge;

import java.util.Collections;
import java.util.List;

public class BridgeGame {

    private final List<String> bridge;
    private int round = 0;
    private int trialCount = 1;
    private boolean success = false;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean move(String moving) {
        increaseRound();
        String row = bridge.get(round - 1);
        boolean result = moving.equals(row);
        this.success = result;
        return result;
    }

    public void retry() {
        increaseTrialCount();
        resetGame();
    }

    private void increaseRound() {
        this.round += 1;
    }

    private void increaseTrialCount() {
        this.trialCount += 1;
    }

    private void resetGame() {
        this.round = 0;
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public int getTrialCount() {
        return trialCount;
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public int getRound() {
        return round;
    }

    public boolean isSuccess() {
        return success;
    }
}
