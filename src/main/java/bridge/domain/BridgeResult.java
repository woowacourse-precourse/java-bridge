package bridge.domain;

public class BridgeResult {

    private final String nowStep;
    private final boolean nowResult;

    public BridgeResult(String nowStep, boolean nowResult) {
        this.nowStep = nowStep;
        this.nowResult = nowResult;
    }

    public boolean isUpMove(){
        if(this.nowStep == "U"){
            return true;
        }
        return false;
    }

    public boolean isSuccessMove(){
        if(this.nowResult == true){
            return true;
        }
        return false;
    }
}
