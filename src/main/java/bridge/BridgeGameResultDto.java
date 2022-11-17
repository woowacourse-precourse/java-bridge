package bridge;

import java.util.List;

public class BridgeGameResultDto {
    private List<List<String>> gradingBoard;
    private boolean isCorrect;

    public void setGradingBoard(List<List<String>> gradingBoard) {
        this.gradingBoard = gradingBoard;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
