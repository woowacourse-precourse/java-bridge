package bridge.model;

import java.util.List;

public class BridgeComparator {

    public String compareBridge(List<String> bridge,String moving, int location){
        if(bridge.get(location).equals(moving)){
            return "O";
        }
        return "X";
    }
}
