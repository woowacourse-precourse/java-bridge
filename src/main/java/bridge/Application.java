package bridge;

import bridge.config.BridgeConfig;

public class Application {

    public static void main(String[] args) {
        BridgeConfig.config().play();
    }
}
