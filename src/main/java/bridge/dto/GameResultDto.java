package bridge.dto;

import bridge.GameResult;
import bridge.GameStatus;
import bridge.domain.Step;
import java.util.List;

public class GameResultDto {

    private final int gameCount;
    private final List<Step> successSteps;
    private final Step failStep;
    private final GameStatus gameStatus;

    public GameResultDto(GameResult gameResult) {
        this.gameCount = gameResult.getGameCount();
        this.successSteps = gameResult.getSuccessSteps();
        this.failStep = gameResult.getFailStep();
        this.gameStatus = gameResult.getGameStatus();
    }

    public int getGameCount() {
        return gameCount;
    }

    public List<Step> getSuccessSteps() {
        return successSteps;
    }

    public Step getFailStep() {
        return failStep;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
