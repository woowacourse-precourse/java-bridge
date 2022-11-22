package model;

import java.util.ArrayList;
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

    public String getResultAt(int position){
        return totalMovingResult.get(position).get(1);
    }

    public int movingResultSize(){
        return totalMovingResult.size();
    }
    public List<Integer> extractUpPosition(){
        List<Integer> upPosition = new ArrayList<>();
        for(int i = 0; i < totalMovingResult.size(); i++)
            if(totalMovingResult.get(i).contains("U"))
                upPosition.add(i);
        return upPosition;
    }
    public List<Integer> extractDownPosition(){
        List<Integer> upPosition = new ArrayList<>();
        for(int i = 0; i < totalMovingResult.size(); i++)
            if(totalMovingResult.get(i).contains("D"))
                upPosition.add(i);
        return upPosition;
    }

}
