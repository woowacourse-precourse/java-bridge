package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.util.TypeConverter;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGame {

    public void start() {
        OutputView.printStartBridgeGame();
        int bridgeSize = InputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        processCrossingBridge(bridge);
    }

    private void processCrossingBridge(List<String> bridge) {
        for (int step = 0; step < bridge.size(); step++) {
            String movingBlock = OutputView.printSelectMovingBlock();

        }
    }
}
