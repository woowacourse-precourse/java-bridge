package bridge;

import bridge.controller.BridgeGameController;
import bridge.service.BridgeGameService;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
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
