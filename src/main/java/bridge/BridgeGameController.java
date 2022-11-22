package bridge;

public class BridgeGameController {
    private static final BridgeGameService bridgeGameService = new BridgeGameService();
    public void run() {
        Integer bridgeSize = bridgeGameService.askBridgeSize();
    }
}
