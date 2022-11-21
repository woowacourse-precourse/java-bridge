package bridge.model;

import static global.advice.InputValidator.RETRY_SIGNAL;
import static global.advice.InputValidator.checkRetryWhether;

import java.util.List;
import java.util.Objects;

public class Score {

    private UserStep userStep;
    private Repetition repetition;


    public Score() {
        this.userStep = new UserStep();
        this.repetition = new Repetition();
    }

    public Score(final UserStep userStep) {
        this.userStep = userStep;
        this.repetition = new Repetition();
    }

    public List<String> getUserStep() {
        return userStep.getUserStep();
    }

    public int getRepetition() {
        return repetition.getRepetition();
    }

    public boolean goOneStep(final Bridge bridge, final String moving) {
        return userStep.goOneStep(bridge, moving);
    }

    public boolean isCrossing(final Bridge bridge) {
        return this.userStep.isCrossing(bridge);
    }

    public String judgeRetry(final String retry) {
        checkRetryWhether(retry);
        if (RETRY_SIGNAL.equals(retry)) {
            this.userStep = this.userStep.setInit();
            this.repetition = this.repetition.increaseCount();
        }
        return retry;
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
        return Objects.equals(userStep, score.userStep) && Objects.equals(repetition, score.repetition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userStep, repetition);
    }
}
