package bridge.vo;

import bridge.vo.enums.Step;

import java.util.Objects;

public class StepResult {
    private final Step step;
    private final boolean isCorrect;

    public StepResult(Step step, boolean isCorrect) {
        this.step = step;
        this.isCorrect = isCorrect;
    }

    public Step getBridgeStep() {
        return step;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) return true;
        if (!(target instanceof StepResult)) return false;
        StepResult anotherStepResult = (StepResult) target;
        return isCorrect == anotherStepResult.isCorrect && step == anotherStepResult.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(step, isCorrect);
    }
}
