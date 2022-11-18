package bridge;

import java.util.List;

public class Application {
    private static final InputView input = new InputView();
    private static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private static final BridgeGame bridgeGame = new BridgeGame();
    public static void main(String[] args) {
        List<String> birdge = bridgeMaker.makeBridge(input.readBridgeSize());

    }
}
