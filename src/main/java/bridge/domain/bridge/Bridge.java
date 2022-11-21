package bridge.domain.bridge;

import bridge.BridgeRandomNumberGenerator;

public class Bridge {
    private BridgeNumber bridgeNumber;
    private BridgeSize bridgeSize;
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    public Bridge(int size){
        this.inputBridgeSize(size);
        this.inputBridgeNumber();
    }
    public void inputBridgeNumber(){
        bridgeNumber = new BridgeNumber(bridgeMaker.makeBridge(bridgeSize.getSize()));
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
