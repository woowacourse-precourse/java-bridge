package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private static final int DEFAULT_TRIAL_NUMBER = 1;
    private static final String SUCCESS_COMMENT = "성공";
    private static final String FAILURE_COMMENT = "실패";

    private int numberOfTrials = DEFAULT_TRIAL_NUMBER;
    private List<Boolean> gameResult = new ArrayList<>();
    private String resultMap;



    public void setGameResult(Boolean result) {
        gameResult.add(result);
    }

    public void setResultMap(String resultMap) {
        this.resultMap = resultMap;
    }

    public List<Boolean> getGameResult() {
        return List.copyOf(gameResult);
    }

    public String getResultMap() {
        return resultMap;
    }

    public void updateNumberOfTrials() {
        numberOfTrials++;
    }
    public int getNumberOfTrials() {
        return numberOfTrials;
    }

    public String getSuccessOrFailure() {
        if (gameResult.contains(Boolean.FALSE)) {
            return FAILURE_COMMENT;
        }
        return SUCCESS_COMMENT;
    }

    public void resetGameResult() {
        this.gameResult = new ArrayList<>();
    }

}
