package bridge;

import static bridge.InputView.readBridgeSize;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

            BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(readBridgeSize()));
        } catch (IllegalArgumentException e) {
        }

    }
}
