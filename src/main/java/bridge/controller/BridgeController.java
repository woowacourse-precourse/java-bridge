package bridge.controller;

import bridge.domain.bridge.*;
import bridge.domain.game.BridgeGame;
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
        boolean hasMoved;
        
        do {
            hasMoved = bridgeGame.move(getBridgeBlock());
            getMoveInfo(bridgeGame.getCrossingResult());
        } while (hasMoved);

    }

    private static void getMoveInfo(String moveInfo) {
        outputView.print(moveInfo);
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
