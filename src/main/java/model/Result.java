package model;

import java.util.List;

public class Result {

    private List<List<String>> totalMovingResult;

    private List<String> currentResult;

    public Result(List<List<String>> totalMovingResult) {
        this.totalMovingResult = totalMovingResult;
    }
    public void setCurrentResult(List<String> currentResult) {
        this.currentResult = currentResult;
    }

    public void addTotalMovingResult(List<String> movingResult){
        totalMovingResult.add(movingResult);
    }
    public void clearResult(){
        totalMovingResult.clear();
        currentResult = null;
    }
}
