package bridge;

import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    private static InputView inputView;
    private static OutputView outputView;
    private static BridgeMaker bridgeMaker;
    private static BridgeGame bridgeGame;

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }
}
