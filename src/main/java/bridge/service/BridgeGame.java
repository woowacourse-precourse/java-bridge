package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.User;
import bridge.util.TypeConverter;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGame {

    private final User user;

    public BridgeGame() {
        this.user = new User();
        start();
    }

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
            user.currentBlock = TypeConverter.blockToNumber(movingBlock);
        }
    }
}
