package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameResult {
    private List<BridgeGameTrialResult> gameResult;

    public BridgeGameResult() {
        gameResult = new ArrayList<>();
    }

    public void addTrial() {
        gameResult.add(new BridgeGameTrialResult());
    }


    public BridgeGameTrialResult getTrialResult(int trial) {
        return gameResult.get(trial - 1);
    }

    public int getTotalTrial() {
        return gameResult.size();
    }

    public BridgeGameTrialResult getCurrentTrialResult() {
        return gameResult.get(getTotalTrial() - 1);
    }
}

