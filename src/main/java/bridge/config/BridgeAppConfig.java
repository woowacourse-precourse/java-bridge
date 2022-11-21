package bridge.config;

import bridge.game.BridgeGame;
import bridge.util.BridgeMaker;
import bridge.util.BridgeNumberGenerator;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeAppConfig {
    public static InputView inputView() {
        return new InputView();
    }

    public static OutputView outputView() {
        return new OutputView();
    }

    public static BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    public static BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }

    public static List<String> generateBridge(int bridgeLength) {
        return bridgeMaker().makeBridge(bridgeLength);
    }

    public static BridgeGame bridgeGame(int bridgeLength) {
        return new BridgeGame(generateBridge(bridgeLength));
    }
}
