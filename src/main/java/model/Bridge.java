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

    public boolean isAccessibleDirection(String direction,int position){
        if(bridgeMap.get(position).equals(direction)){
            return true;
        }
        return false;
    }

}
