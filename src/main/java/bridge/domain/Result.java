package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private static final String RESTART = "R";
    private static final String QUIT = "Q";

    private ResultType resultType;
    private boolean keeping;
    private List<List<String>> allResults;
    private int tryCount;

    public Result(){
        this.resultType = ResultType.FAIL;
        this.keeping = true;
        this.allResults = new ArrayList<>();
        this.tryCount = 0;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public boolean isKeeping() {
        return keeping;
    }

    public List<List<String>> getAllResults() {
        return allResults;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void plusTryCount(){
        this.tryCount = getTryCount()+1;
    }

    public void checkKeeping(String restart){
        if(restart.equals(RESTART))
            keeping = true;
        if(restart.equals(QUIT))
            keeping = false;
    }

    public void combineResult(List<String> up, List<String> down){
        allResults.add(up);
        allResults.add(down);
    }

    public void judgeResult(boolean right){
        if(right)
            resultType = ResultType.SUCCESS;
        if(!right)
            resultType = ResultType.FAIL;
    }

    public void resetAllResult(){
        allResults.clear();
    }

}
