package bridge.domain;

import bridge.util.Constants;

import java.util.List;

public class Bridge {
    private List<String> bridge;

    public Bridge(List<String> bridge){
        this.bridge=bridge;
    }
    public List<String> getBridge(){return  bridge;}
    public String getMoveResult(String moving){
        if(bridge.get(0).equals(moving)) { return Constants.CORRECT; }
        return Constants.WRONG;
    }
}
