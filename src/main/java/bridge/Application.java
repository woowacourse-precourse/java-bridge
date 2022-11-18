package bridge;

import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        int size = InputView.readBridgeSize();

        BridgeRandomNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);

        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.gameStart(bridge);

        OutputView.printCount(bridgeGame.gameCount());
    }
}
