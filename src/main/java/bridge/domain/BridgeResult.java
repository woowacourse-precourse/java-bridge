package bridge.domain;

public class BridgeResult {

    private final String nowMove;
    private final boolean nowResult;

    public BridgeResult(String nowMove, boolean nowResult) {
        this.nowMove = nowMove;
        this.nowResult = nowResult;
    }

    public boolean isUpMove(){
        if(this.nowMove.equals("U")){
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
