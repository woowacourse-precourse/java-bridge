package bridge.domain;

import java.util.List;

public class BridgeGameResult {
    private List<BridgeGameTrialResult> gameResult;


    public void addTrialResult(BridgeGameTrialResult result) {
        gameResult.add(result);
    }

    public BridgeGameTrialResult getTrialResult(int trial) {
        return gameResult.get(trial);
    }

    public int getTrialCount() {
        return gameResult.size();
    }
}

