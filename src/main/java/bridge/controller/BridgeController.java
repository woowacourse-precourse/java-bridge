package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.service.BridgeService;

public class BridgeController {
    private final BridgeService bridgeService = new BridgeService();

    public void gameStart() {
        Bridge bridge = bridgeService.bridgeMaker();
        User user = new User();
    }
}
