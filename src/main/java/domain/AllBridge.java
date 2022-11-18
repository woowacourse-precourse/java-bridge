package domain;


import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;

import java.util.ArrayList;
import java.util.List;

public class AllBridge {
    private List<String> bridge = new ArrayList<>();
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    InputView inputView = new InputView();

    public AllBridge() {
        int bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public List<String> getBridge() {
        return bridge;
    }



}
