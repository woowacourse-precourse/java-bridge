package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameTrialResult {
    private List<Boolean> trialResult;

    public BridgeGameTrialResult() {
        trialResult = new ArrayList<>();
    }

    public void addRoundResult(boolean roundResult) {
        trialResult.add(roundResult);
    }

    public boolean isPreviousRoundSucceeded(int currentRound) {
        try {
            return trialResult.get(currentRound - 2);
        } catch (IndexOutOfBoundsException exception) {
            throw new IndexOutOfBoundsException("2라운드부터 마지막 라운드까지만 이전 라운드 결과가 체크 가능합니다");
        }
    }

    public boolean didCrossedBridge(int bridgeLength) {
        return bridgeLength == trialResult.size() && getRoundResult(getTotalRound());
    }

    public boolean getRoundResult(int round) {
        return trialResult.get(round - 1);
    }

    public int getTotalRound() {
        return trialResult.size();
    }
}
