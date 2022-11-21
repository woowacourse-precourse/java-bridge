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
        play(bridgeSize, bridgeGame);
    }

    private static void play(String bridgeSize, BridgeGame bridgeGame) {
        boolean hasMoved;
        int count = Integer.parseInt(bridgeSize);

        do {
            count--;
            hasMoved = bridgeGame.move(getBridgeBlock());
            printMoveInfo(bridgeGame.getCrossingResult());
        } while (hasMoved && count > 0);

        if (!hasMoved) {
            boolean isRetry = bridgeGame.retry(getRetry());
            if (isRetry) {
                play(bridgeSize, bridgeGame);
            }
        }
    }

    private static void printMoveInfo(String moveInfo) {
        outputView.printMap(moveInfo);
    }

    private static String getBridgeBlock() {
        outputView.printMove();
        return inputView.readMoving();
    }

    private static String getBridgeSize() {
        outputView.printStart();
        return inputView.readBridgeSize();
    }

    private static String getRetry() {
        outputView.printRetry();
        return inputView.readGameCommand();
    }
}
