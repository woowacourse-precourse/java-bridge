package model;

import java.util.List;

public class Bridge {
    final List<String> bridgeMap;

    public Bridge(List<String> bridgeMap){
        this.bridgeMap = bridgeMap;
    }

    public boolean isAccessiblePosition(int distance,String direction){
        if(bridgeMap.get(distance).equals(direction)){
            return true;
        }
        return false;
    }

    public boolean isUnderBridgeSize(int userSize){
        return userSize < bridgeMap.size();
    }
}
