package bridge.domain.bridge;

import java.util.List;

public class BridgeNumber {
    List<String> bridgeNumber;
    public BridgeNumber(List<String> number){
        bridgeNumber = number;
    }
    public boolean numberTypeCheck(int index){
        return bridgeNumber.get(index).equals("D");
    }
    public String getBridgeNumber(int index){
        return bridgeNumber.get(index);
    }
}
