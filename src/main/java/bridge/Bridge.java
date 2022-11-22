package bridge;

import java.util.List;

public class Bridge {
    private int bridgeSize;
    private List<String> bridgeState;
    private BridgeMaker bridgeMaker;
    private BridgeNumberGenerator bridgeNumberGenerator;

    public Bridge(int bridgeSize){
        this.bridgeSize = bridgeSize;
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeState = bridgeMaker.makeBridge(bridgeSize);
    }

    public List<String> getBrideState(){
        return bridgeState;
    }

    public int getBrideSize(){
        return bridgeSize;
    }
}