package bridge;

import bridge.service.BridgeGameService;

public class Application {

    public static void main(String[] args) {
        new BridgeGameService().start();
    }
}
