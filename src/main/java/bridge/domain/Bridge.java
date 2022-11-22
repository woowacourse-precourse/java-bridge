package bridge.domain;

import bridge.util.Constants;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge){
        this.bridge=bridge;
    }
    public List<String> getBridge(){return  bridge;}
    public int getBridgeSize(){ return bridge.size(); }
    public String getMoveResult(String moving, int index){
        if(bridge.get(index).equals(moving)) { return Constants.CORRECT; }
        return Constants.WRONG;
    }
}
