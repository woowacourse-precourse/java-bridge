package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        outputView.startGame();

        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        int bridgeSize = inputView.readBridgeSize();
        if (bridgeSize==0) {
            return;
        }
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.simulate(bridge);
    }

}
