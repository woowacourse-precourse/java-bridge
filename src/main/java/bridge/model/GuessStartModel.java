package bridge.model;

import java.util.ArrayList;
import java.util.List;

import static bridge.view.OutputView.failMessage;

public class GuessStartModel {
    private int cntTries;
    private String gameResult;
    private boolean retryResult;
    private List<String> saveTotalMove;

    public GuessStartModel(){
        this.cntTries=0;
        this.gameResult = failMessage;
        this.retryResult = true;
        this.saveTotalMove = new ArrayList<>();
    }

    public int getCntTries() {
        return cntTries;
    }
    public String getGameResult() {
        return gameResult;
    }
    public boolean getRetryResult(){
        return retryResult;
    }
    public List<String> getSaveTotalMove() {
        return saveTotalMove;
    }

    public void setCntTries(int cntTries){
        this.cntTries = cntTries;
    }
    public void setGameResult(String gameResult){
        this.gameResult = gameResult;
    }
    public void setRetryResult(boolean retryResult){
        this.retryResult = retryResult;
    }
    public void setSaveTotalMove(List<String> saveTotalMove){
        this.saveTotalMove = saveTotalMove;
    }
}
