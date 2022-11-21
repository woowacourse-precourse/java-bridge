package bridge.domain.bridge;

import java.util.List;

public class Bridge {
    private BridgeNumber bridgeNumber;
    private BridgeSize bridgeSize;
    public void inputBridgeNumber(List<String> number){
        bridgeNumber = new BridgeNumber(number);
    }
    public void inputBridgeSize(int size){
        bridgeSize = new BridgeSize(size);
    }
    public BridgeNumber getBridgeNumber(int index){
        return bridgeNumber;
    }
    public BridgeSize getBridgeSize(){
        return bridgeSize;
    }
}
