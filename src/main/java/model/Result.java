package model;

import java.util.List;

public class Result {

    private List<String> totalMovingResult;
    private String currentResult;

    public Result(List<String> totalMovingResult) {
        this.totalMovingResult = totalMovingResult;
    }

    public String getCurrentResult() {
        return currentResult;
    }

    public void setCurrentResult(String currentResult) {
        this.currentResult = currentResult;
    }

    public List<String> getTotalMovingResult() {
        return totalMovingResult;
    }

    public void addMovingResult(String movingResult){
        totalMovingResult.add(movingResult);
    }
}
