package bridge;

import bridge.controller.BridgeGame;
import bridge.service.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeGame bridgeGame = BridgeGame.create(new InputView(), new OutputView(),
                new BridgeMaker(bridgeRandomNumberGenerator));
        try {
            bridgeGame.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
