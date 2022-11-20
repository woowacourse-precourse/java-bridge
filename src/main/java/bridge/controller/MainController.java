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

    public static BridgeGame makeBridgeGame(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        System.out.println(bridge);
        return new BridgeGame(bridge);
    }

    public static void processBridgeGame(BridgeGame bridgeGame) {
        do {
            String direction = new BridgeMove(InputView.readMoving()).get();
            boolean isCorrect = bridgeGame.move(direction);
            OutputView.printMap(bridgeGame.getBridgeMap().get());
            if (!isCorrect) {
                BridgeCommand bridgeCommand = new BridgeCommand(InputView.readGameCommand());
                if (!bridgeCommand.getIsRetry()) {
                    break;
                }
                bridgeGame.retry();
            }
        } while (!bridgeGame.checkEnd());
    }

}
