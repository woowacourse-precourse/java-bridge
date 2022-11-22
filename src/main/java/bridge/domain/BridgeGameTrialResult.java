package bridge.domain;

import java.util.Map;
import java.util.TreeMap;

public class BridgeGameTrialResult {
    private Map<Integer, BridgeGameRoundResult> trialResult;

    public BridgeGameTrialResult() {
        trialResult = new TreeMap<>();
    }

    public void addRoundResult(int round, BridgeMove move, boolean roundResult) {
        trialResult.put(round, new BridgeGameRoundResult(move, roundResult));
    }

    public boolean isPreviousRoundSucceeded(int currentRound) {
        try {
            return trialResult.get(currentRound - 1).passed();
        } catch (IndexOutOfBoundsException exception) {
            throw new IndexOutOfBoundsException("2라운드부터 마지막 라운드까지만 이전 라운드 결과가 체크 가능합니다.");
        }
    }

    public boolean didCrossedBridge(int bridgeLength) {
        return bridgeLength == trialResult.size() && getRoundResult(getTotalRound()).passed();
    }


    public BridgeGameRoundResult getRoundResult(int round) {
        if (round < 1 || round > trialResult.size()) {
            throw new IndexOutOfBoundsException("유효하지 않은 round 입니다.");
        }
        return trialResult.get(round);
    }

    public Map<Integer, BridgeGameRoundResult> getTrialResult() {
        return trialResult;
    }

    public int getTotalRound() {
        return trialResult.size();
    }
}
