package bridge;

import bridge.bridge.BridgeNumberGenerator;
import bridge.bridge.BridgeRandomNumberGenerator;
import bridge.bridgeGame.BridgeGameRunner;

public class Application {

    public static void main(String[] args) {
        final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        final BridgeGameRunner bridgeGameRunner = new BridgeGameRunner(bridgeNumberGenerator);
        try {
            bridgeGameRunner.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
