package bridge.controller;

import bridge.domain.bridge.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private static final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();

    public static void run() {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        String bridgeSize = getBridgeSize();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));

        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move(getBridgeBlock());
    }

    private static String getBridgeBlock() {
        outputView.printMove();
        return inputView.readMoving();
    }

    private static String getBridgeSize() {
        outputView.printStart();
        return inputView.readBridgeSize();
    }

}
