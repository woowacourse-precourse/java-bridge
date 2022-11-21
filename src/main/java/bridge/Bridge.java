package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> bridgeShape;
    private List<String> moveTrace = new ArrayList<>();
    private Integer attemptNumber = 0;

    public Bridge(List<String> bridgeShape){
        this.bridgeShape = bridgeShape;
    }

    void setBridgeShape(List<String> bridgeShape){
        this.bridgeShape = bridgeShape;
    }

    public Integer getAttemptNumber() {
        return attemptNumber;
    }

    public List<String> getBridgeShape() {
        return this.bridgeShape;
    }

    public List<String> getMoveTrace() {
        return this.moveTrace;
    }

    public void reGame(){
        moveTrace.clear();
        ++attemptNumber;
    }
}
