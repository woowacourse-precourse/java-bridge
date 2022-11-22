package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

        BridgeGameController controller = new BridgeGameController();
        controller.init(bridgeNumberGenerator);
        controller.run();
    }
}
