package model;

import java.util.List;

public class Result {

    private List<String> totalMovingResult;

    public Result(List<String> totalMovingResult) {
        this.totalMovingResult = totalMovingResult;
    }

    public List<String> getTotalMovingResult() {
        return totalMovingResult;
    }

    public void addMovingResult(String movingResult){
        totalMovingResult.add(movingResult);
    }
}
