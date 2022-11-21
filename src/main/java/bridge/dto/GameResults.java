package bridge.dto;

import java.util.Collections;
import java.util.List;

public class GameResults {

    private final List<TrialResult> trialResults;
    private final int trialCount;

    public GameResults(List<TrialResult> trialResults, int trialCount) {
        this.trialResults = trialResults;
        this.trialCount = trialCount;
    }

    public int getTrialCount() {
        return trialCount;
    }

    public List<TrialResult> getTrialResults() {
        return Collections.unmodifiableList(trialResults);
    }
}
