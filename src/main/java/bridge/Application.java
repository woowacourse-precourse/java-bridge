package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.BridgeGame;
import bridge.ui.InputView;
import bridge.ui.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGameController bridgeGameController = new BridgeGameController(
                new BridgeGame(), new BridgeMaker(new BridgeRandomNumberGenerator()),
                new OutputView(), new InputView()
        );
        bridgeGameController.play();
    }
}
