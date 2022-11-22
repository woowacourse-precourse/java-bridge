package bridge.domain;

public class BridgeGame {
    private static final int INITIAL_COUNT = 1;
    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";
    private static final String CORRECT_MOVE = "O";
    private static final String WRONG_MOVE = "X";

    private final OneSideResults upsideResults;
    private final OneSideResults downsideResults;
    
    private int totalTrialCount;
    private String finalResult;

    public BridgeGame() {
        upsideResults = new UpsideResults();
        downsideResults = new DownsideResults();
        
        totalTrialCount = INITIAL_COUNT;
        finalResult = SUCCESS;
    }

    public String move(String playerMove, String answerMove) {
        if (playerMove.equals(answerMove)) {
            return CORRECT_MOVE;
        }
        return WRONG_MOVE;
    }

    public void retry() {
        resetBothSidesResults();
        totalTrialCount++;
    }

    public void quit() {
        finalResult = FAILURE;
    }

    public void updateBothSidesResults(String playerMove, String matchResult) {
        upsideResults.update(playerMove, matchResult);
        downsideResults.update(playerMove, matchResult);
    }

    public void resetBothSidesResults() {
        upsideResults.reset();
        downsideResults.reset();
    }
    
    public boolean hasWrongMove() {
        return checkIfUpsideResultsContainsWrongMove() ||
                checkIfDownsideResultsContainsWrongMove();
    }
    
    public boolean checkIfUpsideResultsContainsWrongMove() {
        return upsideResults.getResults().contains(WRONG_MOVE);
    }

    public boolean checkIfDownsideResultsContainsWrongMove() {
        return downsideResults.getResults().contains(WRONG_MOVE);
    }

    public OneSideResults getUpsideResults() {
        return upsideResults;
    }

    public OneSideResults getDownsideResults() {
        return downsideResults;
    }

    public String getFinalResult() {
        return finalResult;
    }

    public int getTotalTrialCount() {
        return totalTrialCount;
    }
}
