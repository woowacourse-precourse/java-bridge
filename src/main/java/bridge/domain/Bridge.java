package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;

import java.util.List;

public class Bridge {
    private List<String> bridgeNumber;
    public Bridge(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        InputView inputView = new InputView();
        bridgeNumber = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
    public List<String> getBridgeNumber(){
        return bridgeNumber;
    }
}
