package bridge.controller;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    InputView inputView = new InputView();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    OutputView outputView = new OutputView();
    List<String> bridgeData = new ArrayList<>();

    public void run() {
        try {
            bridgeData = bridgeMaker.makeBridge(Integer.parseInt(inputView.readBridgeSize()));
            outputView.printMap(bridgeData);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}