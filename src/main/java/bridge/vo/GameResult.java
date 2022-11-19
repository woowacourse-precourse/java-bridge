package bridge.vo;

import java.util.Collections;
import java.util.List;

public class GameResult {
    private final List<StepResult> stepResults;
    private final TryCount tryCount;

    public GameResult(List<StepResult> stepResults, TryCount tryCount) {
        this.stepResults = Collections.unmodifiableList(stepResults);
        this.tryCount = tryCount;
    }

    public List<StepResult> getStepResults() {
        return stepResults;
    }

    public TryCount getTryCount() {
        return tryCount;
    }

    public boolean isFinishedFrom(Bridge bridge) {
        return stepResults.size() == bridge.size();
    }
}
