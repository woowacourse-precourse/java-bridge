package bridge.model;

import static global.advice.InputValidator.RETRY_SIGNAL;
import static global.advice.InputValidator.checkMoving;
import static global.advice.InputValidator.checkRetryWhether;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Score {

    private List<String> userStep;
    private int retryCount;

    public Score() {
        this.userStep = new ArrayList<>();
        this.retryCount = 1;
    }

    public Score(List<String> userStep) {
        this.userStep = userStep;
        this.retryCount = 1;
    }

    public boolean goOneStep(Bridge bridge, String moving) {
        checkMoving(moving);
        this.userStep.add(moving);
        return bridge.canGoOrNot(this.userStep, moving);
    }

    public boolean isCrossing(Bridge bridge) {
        return bridge.isCrossing(this.userStep.size());
    }

    public String judgeRetry(String retry) {
        checkRetryWhether(retry);
        if (RETRY_SIGNAL.equals(retry)) {
            this.userStep = new ArrayList<>();
            this.retryCount += 1;
        }
        return retry;
    }

    public List<String> getUserStep() {
        return userStep;
    }

    public int getRetryCount() {
        return retryCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Score score = (Score) o;
        return retryCount == score.retryCount && Objects.equals(userStep, score.userStep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userStep, retryCount);
    }
}
