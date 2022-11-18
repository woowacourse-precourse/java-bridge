package model;

import java.util.List;

public class Bridge {
    List<String> bridgeMap;

    public Bridge(List<String> bridgeMap){
        this.bridgeMap = bridgeMap;
    }

    public int getBridgeSize() {
        return bridgeMap.size();
    }

    public boolean isAccessiblePosition(int distance,String direction){
        if(bridgeMap.get(distance).equals(direction)){
            return true;
        }
        return false;
    }
}
