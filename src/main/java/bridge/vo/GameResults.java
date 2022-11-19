package bridge.vo;

import java.util.List;

import bridge.dto.TrialResult;

public class GameResults {

    private static final int SIZE_AND_INDEX_DIFFERENCE = 1;

    private final List<TrialResult> trialResults;
    private final boolean isFinished;

    public GameResults(List<TrialResult> trialResults, boolean isFinished) {
        this.trialResults = trialResults;
        this.isFinished = isFinished;
    }

    public boolean wasLastSuccessful() {
        TrialResult trialResult = trialResults.get(lastIndex());
        return trialResult.wasSuccessful();
    }

    private int lastIndex() {
        return trialResults.size() - SIZE_AND_INDEX_DIFFERENCE;
    }

    public boolean isFinished() {
        return isFinished;
    }
}
