package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.bridge.BridgeGame;
import bridge.domain.bridge.BridgeMove;
import bridge.domain.bridge.BridgeSize;
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
        while (true) {
            BridgeMove move = new BridgeMove(InputView.readMoving());
            boolean isCanMove = bridgeGame.move(move.get());
            OutputView.printMap(bridgeGame.getBridgeMap());
        }
    }

}
