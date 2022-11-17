package bridge;

import java.util.List;
import java.util.Map;

public class BridgeGameResultDto {
    private List<Map<UpDown,Boolean>> gradingBoard;
    private boolean isCorrect;

    public BridgeGameResultDto(List<Map<UpDown, Boolean>> gradingBoard, boolean isCorrect) {
        this.gradingBoard = gradingBoard;
        this.isCorrect = isCorrect;
    }

    public List<Map<UpDown, Boolean>> getGradingBoard() {
        return gradingBoard;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
