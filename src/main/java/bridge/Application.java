package bridge;

import bridge.domain.game.BridgeGameController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    
    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController(new InputView(), new OutputView());
        bridgeGameController.start(new BridgeRandomNumberGenerator());
    }
}
