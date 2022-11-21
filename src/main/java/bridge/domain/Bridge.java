package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;

import java.util.List;

public class Bridge {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private List<String> bridgeNumber;
    private BridgeSize bridgeSize;
    InputView inputView = new InputView();
    public List<String> getBridgeNumber(){
        return bridgeNumber;
    }
    private Boolean isBridgeValid(){
        return true;
    }
    public void inputBridgeNumber(){
        bridgeNumber = bridgeMaker.makeBridge(bridgeSize.getSize());
        isBridgeValid();
    }
    public void inputBridegeSize(){
        bridgeSize = new BridgeSize(inputView.readBridgeSize());
    }
}
