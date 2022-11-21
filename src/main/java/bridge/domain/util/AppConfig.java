package bridge.domain.util;

import bridge.controller.BridgeGameController;
import bridge.domain.BridgeGameManager;
import bridge.domain.UserBridge;
import bridge.service.BridgeGameService;

public class AppConfig {
    public BridgeGameController bridgeGameController() {
        return new BridgeGameController(bridgeGameService());
    }

    private BridgeGameService bridgeGameService() {
        return new BridgeGameService(bridgeGameManager(), userBridge());
    }

    private BridgeGameManager bridgeGameManager() {
        return new BridgeGameManager();
    }

    private UserBridge userBridge() {
        return new UserBridge();
    }
}
