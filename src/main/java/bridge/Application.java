package bridge;

import bridge.service.BridgeGameService;

public class Application {

    public static void main(String[] args) {
        BridgeGameService bridgeGameService = new BridgeGameService();
        try {
            bridgeGameService.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
