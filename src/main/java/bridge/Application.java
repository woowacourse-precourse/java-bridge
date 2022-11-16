package bridge;

import bridge.Validation.Validation;
import bridge.View.InputView;
import bridge.View.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.start(new InputView(), new OutputView());
    }
}
