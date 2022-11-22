package bridge;

import bridge.domain.Step;
import java.util.LinkedList;
import java.util.List;

public class GameResult {

    private int gameCount = 0;
    private List<Step> successSteps;
    private Step failStep;
    private GameStatus gameStatus;

    public GameResult() {
        reset();
    }

    public void reset() {
        gameCount++;
        successSteps = new LinkedList<>();
        failStep = null;
        gameStatus = GameStatus.DOING;
    }

    public void addResult(Step tryStep, boolean success) {
        if (success) {
            addSuccessStep(tryStep);
            return;
        }
        failStep = tryStep;
        gameStatus = GameStatus.FAIL;
    }

    public void setGameSuccess() {
        gameStatus = GameStatus.SUCCESS;
    }

    private void addSuccessStep(Step successStep) {
        successSteps.add(successStep);
    }

    public int getGameCount() {
        return this.gameCount;
    }

    public List<Step> getSuccessSteps() {
        return this.successSteps;
    }

    public Step getFailStep() {
        return this.failStep;
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

}
