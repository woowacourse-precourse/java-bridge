package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, inputView, outputView);
        bridgeGame.run();
    }
}
