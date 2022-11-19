package bridge;

import bridge.Service.BridgeService;

public class Application {

    public static void main(String[] args) {
        new BridgeService().startService();
    }
}
