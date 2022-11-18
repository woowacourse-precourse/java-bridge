package bridge.vo;

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
}
