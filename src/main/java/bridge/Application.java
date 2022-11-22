package bridge;

import bridge.application.BridgeGameApplication;
import bridge.application.config.BridgeGameConfig;

public class Application {

    public static void main(String[] args) {
        BridgeGameConfig config = new BridgeGameConfig();
        BridgeGameApplication gameApplication = new BridgeGameApplication(config);
        gameApplication.start();
    }
}
