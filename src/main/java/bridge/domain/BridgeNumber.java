package bridge.domain;

import java.util.LinkedList;
import java.util.List;

public class BridgeNumber {
    List<String> bridgeNumber = new LinkedList<>();
    public BridgeNumber(List<String> number){
        bridgeNumber = number;
        isBridgeValid();
    }
    public List<String> getBridgeNumber(){
        return bridgeNumber;
    }
    private Boolean isBridgeValid(){
        return true;
    }
}
