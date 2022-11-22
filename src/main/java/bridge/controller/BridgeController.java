package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void run() {
        outputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        for (String s : bridge) {
            System.out.print(s);
        }
        System.out.println();

        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.start();
    }
}
