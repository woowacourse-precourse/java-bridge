package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private ResultType resultType;
    private boolean keeping;
    private List<List<String>> allResult;
    private int tryCount;

    public Result(){
        this.resultType = ResultType.FAIL;
        this.keeping = true;
        this.allResult = new ArrayList<>();
        this.tryCount = 0;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public boolean isKeeping() {
        return keeping;
    }

    public List<List<String>> getAllResult() {
        return allResult;
    }

    public int getTryCount() {
        return tryCount;
    }
    public void plusTryCount(){
        this.tryCount = getTryCount()+1;
    }

    public void setKeeping(boolean keeping){
        this.keeping = keeping;
    }
    public void checkKeeping(String restart){
        if(restart.equals("R")){
            keeping = true;
        }
        if(restart.equals("Q"))
            keeping = false;
    }
    public void combineResult(List<String> up, List<String> down){
        allResult.clear();
        allResult.add(up);
        allResult.add(down);
    }
    public void judgeResult(boolean right){
        if(right)
            resultType = ResultType.SUCCESS;
        if(!right)
            resultType = ResultType.FAIL;
    }
    public void resetAllResult(){
        allResult.clear();
    }

}
