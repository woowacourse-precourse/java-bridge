package bridge;

import java.util.List;

public class BridgeGameResultDto {
    private List<List<String>> gradingBoard;
    private boolean isCorrect;

    public BridgeGameResultDto(List<List<String>> gradingBoard, boolean isCorrect) {
        this.gradingBoard = gradingBoard;
        this.isCorrect = isCorrect;
    }
}
