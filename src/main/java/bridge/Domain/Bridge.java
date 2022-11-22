package bridge.Domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Controller.Validation;

import java.util.List;

public class Bridge {
    private List<String> bridge;
    private BridgeNumberGenerator bridgeNumberGenerator;
    private BridgeMaker bridgeMaker;

    public Bridge(String size){
        Validation.validateBridgeSize(size);
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(Integer.parseInt(size));
    }

    public List<String> getBridge(){
        return bridge;
    }
}
