package bridge;

import java.util.List;

public class BridgeGameResultDto {
    private List<Answer> gradingBoard;
    private boolean isCorrect;

    public BridgeGameResultDto(List<Answer> gradingBoard, boolean isCorrect) {
        this.gradingBoard = gradingBoard;
        this.isCorrect = isCorrect;
    }
}
