package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private static final BridgeGameService bridgeGameService = new BridgeGameService();

    private List<String> bridge = new ArrayList<>();
    private List<String> map = new ArrayList<>();

    public void run() {
        Integer bridgeSize = bridgeGameService.askBridgeSize();
        bridge = bridgeGameService.makeBridge(bridgeSize);

        do {
            map.add(bridgeGameService.askMoving());
            bridgeGameService.printMapStatus(bridge, map);
        } while (bridgeGameService.isMovable(bridge, map));

    }
}
