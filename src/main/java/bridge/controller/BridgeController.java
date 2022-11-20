package bridge.controller;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    InputView inputView = new InputView();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    List<String> bridgeData = new ArrayList<>();

    public void run() {
        try {
            bridgeData = bridgeMaker.makeBridge(Integer.parseInt(inputView.readBridgeSize()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}