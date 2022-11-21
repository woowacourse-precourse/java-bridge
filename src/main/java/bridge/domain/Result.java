package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private List<Boolean> gameResult = new ArrayList<>();
    private String resultMap;
    private int numberOfTrials = 1;

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
            return "실패";
        }
        return "성공";
    }

    public void resetGameResult() {
        this.gameResult = new ArrayList<>();
    }

}
