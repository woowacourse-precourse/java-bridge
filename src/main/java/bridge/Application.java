package bridge;

import bridge.domain.*;
import bridge.state.ErrorState;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();
        if (bridgeSize == -1) { return; }
        Bridge bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        OutputView outputView = new OutputView(bridgeGame);
        if (bridgeGame.proceed(inputView, outputView) == ErrorState.ERROR) { return; }
        outputView.printResult();
    }
}
