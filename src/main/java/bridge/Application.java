package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.service.BridgeGameService;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController(bridgeGameService());
        bridgeGameController.run();
    }

    public static BridgeGameService bridgeGameService() {
        return new BridgeGameService(bridgeMaker());
    }

    public static BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }

    public static BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }
}
