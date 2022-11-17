package model;

import java.util.List;

public class BridgeMap {
    List<String> builtBridge;

    public BridgeMap(List<String> builtBridge){
        this.builtBridge = builtBridge;
    }

    public int getBridgeSize() {
        return builtBridge.size();
    }

    public boolean canMoveMore(String direction,int distance){
        if(builtBridge.get(distance).equals(direction)){
            return true;
        }
        return false;
    }

}
