package bridge.bridgeGame;

import bridge.enums.GameStatus;

import java.util.List;

public class BridgeGameResultDto {
    private List<StepStatus> gradingBoard;
    private GameStatus gameStatus;
    private int totalAttemptNum;

    public BridgeGameResultDto(List<StepStatus> gradingBoard, GameStatus gameStatus, int totalAttemptNum) {
        this.gradingBoard = gradingBoard;
        this.gameStatus = gameStatus;
        this.totalAttemptNum = totalAttemptNum;
    }

    public List<StepStatus> getGradingBoard() {
        return gradingBoard;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int getTotalAttemptNum() {
        return totalAttemptNum;
    }
}
