package bridge;

import java.util.List;
import java.util.Map;

public class BridgeGameResultDto {
    private List<StepStatus> gradingBoard;
    private boolean isCorrect;

    public BridgeGameResultDto(List<StepStatus> gradingBoard, boolean isCorrect) {
        this.gradingBoard = gradingBoard;
        this.isCorrect = isCorrect;
    }

    public List<StepStatus> getGradingBoard() {
        return gradingBoard;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
