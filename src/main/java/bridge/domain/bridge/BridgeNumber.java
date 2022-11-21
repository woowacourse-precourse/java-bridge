package bridge.domain.bridge;

import java.util.List;

public class BridgeNumber {
    List<String> bridgeNumber;
    public BridgeNumber(List<String> number){
        bridgeNumber = number;
        isBridgeValid();
    }
    public boolean numberTypeCheck(int index){
        return bridgeNumber.get(index).equals("0");
    }
    private boolean isBridgeValid(){
        return true;
    }
}
