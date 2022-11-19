package bridge.vo;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object target) {
        if (this == target) return true;
        if (!(target instanceof GameResult)) return false;
        GameResult anotherGameResult = (GameResult) target;
        return stepResults.equals(anotherGameResult.stepResults) && tryCount.equals(anotherGameResult.tryCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stepResults, tryCount);
    }
}
