package bridge;

import bridge.service.BridgeGameService;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGameService bridgeGameService = new BridgeGameService();
        bridgeGameService.init();
    }
}
