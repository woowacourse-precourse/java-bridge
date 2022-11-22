package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private static final BridgeGameService bridgeGameService = new BridgeGameService();

    private List<String> bridge = new ArrayList<>();

    public void run() {
        Integer bridgeSize = bridgeGameService.askBridgeSize();
        bridge = bridgeGameService.makeBridge(bridgeSize);
    }
}
