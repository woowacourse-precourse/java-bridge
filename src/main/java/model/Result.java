package model;

import java.util.List;

public class Result {

    private List<String> totalMovingResult;

    public void setMovingResult(List<String> totalMovingResult, String movingResult) {
        totalMovingResult.add(movingResult);
        this.totalMovingResult = totalMovingResult;
    }

    public List<String> getTotalMovingResult() {
        return totalMovingResult;
    }
}
