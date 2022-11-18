package bridge;

import java.util.List;
import java.util.Map;

public class BridgeGameResultDto {
    private List<StepStatus> gradingBoard;
    private GameStatus gameStatus;

    public BridgeGameResultDto(List<StepStatus> gradingBoard, GameStatus gameStatus) {
        this.gradingBoard = gradingBoard;
        this.gameStatus = gameStatus;
    }

    public List<StepStatus> getGradingBoard() {
        return gradingBoard;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
