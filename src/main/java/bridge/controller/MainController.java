package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.bridge.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class MainController {
    public static void run() {
        BridgeSize bridgeSize = new BridgeSize(InputView.readBridgeSize());
        BridgeGame bridgeGame = makeBridgeGame(bridgeSize.get());
        processBridgeGame(bridgeGame);
    }

    private static BridgeGame makeBridgeGame(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        return new BridgeGame(bridge);
    }

    private static void processBridgeGame(BridgeGame bridgeGame) {
        do {
            if (!processTurn(bridgeGame)) {
                break;
            }
        } while (!bridgeGame.checkEnd());
    }

    private static boolean processTurn(BridgeGame bridgeGame) {
        moveBridge(bridgeGame);
        if (!bridgeGame.getLastState()) {
            if(!askRetry()) {
                bridgeGame.end();
                return false;
            }
            bridgeGame.retry();
        }
        return true;
    }

    private static void moveBridge(BridgeGame bridgeGame) {
        String direction = new BridgeMove(InputView.readMoving()).get();
        bridgeGame.move(direction);
        OutputView.printMap(bridgeGame.getBridgeMap().get());
    }

    public static boolean askRetry() {
        BridgeCommand bridgeCommand = new BridgeCommand(InputView.readGameCommand());
        return bridgeCommand.getIsRetry();
    }

}
