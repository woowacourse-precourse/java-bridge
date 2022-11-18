package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.service.BridgeGame;
import bridge.service.BridgeService;

public class BridgeController {
    private final BridgeService bridgeService = new BridgeService();
    private final BridgeGame bridgeGame = new BridgeGame();

    public void start() {
        Bridge bridge = bridgeService.bridgeMaker();
        User user = new User();
        bridgeGame.gameStart(bridge, user);
    }
}
