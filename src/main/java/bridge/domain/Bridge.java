package bridge.domain;

import java.util.List;

public class Bridge {
    private List<String> bridgeNumber;
    private BridgeSize bridgeSize;
    public int getBridgeNumber(int index){
        return Integer.parseInt(bridgeNumber.get(index));
    }
    private Boolean isBridgeValid(){
        return true;
    }
    public void inputBridgeNumber(List<String> number){
        bridgeNumber = number;
        isBridgeValid();
    }
    public void inputBridegeSize(int size){
        bridgeSize = new BridgeSize(size);
    }
}
