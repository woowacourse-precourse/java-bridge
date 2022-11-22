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
        play(Integer.parseInt(bridgeSize), bridgeGame);

        getResult(bridgeGame.getCrossingResult(), bridgeGame.isFail(), bridgeGame.getAttempt());
    }

    private static void getResult(String result, String success, int attempt) {
        outputView.printResult(result, success, attempt);
    }

    private static void play(int bridgeSize, BridgeGame bridgeGame) {
        if (!hasMoved(bridgeSize, bridgeGame)) {
            boolean isRetry = bridgeGame.retry(getRetry());
            if (isRetry) {
                play(bridgeSize, bridgeGame);
            }
        }
    }

    private static boolean hasMoved(int bridgeSize, BridgeGame bridgeGame) {
        boolean hasMoved;

        do {
            bridgeSize--;
            hasMoved = bridgeGame.move(getBridgeBlock());
            printMoveInfo(bridgeGame.getCrossingResult());
        } while (hasMoved && bridgeSize > 0);

        return hasMoved;
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
