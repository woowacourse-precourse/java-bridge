package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.bridge.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class MainController {
    public static void run() {
        OutputView.printWelcome();
        BridgeSize bridgeSize = getBridgeSize();
        BridgeGame bridgeGame = makeBridgeGame(bridgeSize.get());
        processBridgeGame(bridgeGame);
    }

    private static BridgeSize getBridgeSize() {
        while (true) {
            try {
                BridgeSize bridgeSize = new BridgeSize(InputView.readBridgeSize());
                return bridgeSize;
            } catch (IllegalArgumentException E) {
                System.out.printf(E.getMessage());
            }
        }
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

    private static String getDirection() {
        while (true) {
            try {
                String direction = new BridgeMove(InputView.readMoving()).get();
                return direction;
            } catch (IllegalArgumentException E) {
                System.out.printf(E.getMessage());
            }
        }
    }

    private static void moveBridge(BridgeGame bridgeGame) {
        String direction = getDirection();
        bridgeGame.move(direction);
        OutputView.printMap(bridgeGame.getBridgeMap().get());
    }

    private static boolean askRetry() {
        while (true) {
            try {
                BridgeCommand bridgeCommand = new BridgeCommand(InputView.readGameCommand());
                return bridgeCommand.getIsRetry();
            } catch (IllegalArgumentException E) {
                System.out.printf(E.getMessage());
            }
        }
    }
}
