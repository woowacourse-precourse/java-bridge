package bridge;

import bridge.controller.BridgeGame;
import bridge.util.BridgeMaker;
import bridge.service.BridgeService;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = BridgeGame.create(new BridgeService(bridgeMaker, new InputView(), new OutputView()));
        try {
            bridgeGame.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
