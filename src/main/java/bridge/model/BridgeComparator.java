package bridge.model;

import java.util.List;

public class BridgeComparator {

    public String compareBridge(List<String> bridge,String moving, int location){
        if(bridge.get(location).equals(moving)){
            return "O";
        }
        return "X";
    }


    public boolean isExpressionX(int location,List<String> bridgeUpMap,List<String> bridgeDownMap){
        if(bridgeUpMap.get(location).equals("X")){
            return true;
        }
        if(bridgeDownMap.get(location).equals("X")){
            return true;
        }
        return false;
    }
}
