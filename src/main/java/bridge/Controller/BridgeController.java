package bridge.Controller;

import bridge.Domain.Bridge;
import bridge.Domain.UserBridges;
import bridge.Service.BridgeService;
import bridge.Service.GameService;
import bridge.View.OutputView;

public class BridgeController {
    private final BridgeService bridgeService = new BridgeService();
    private final GameService gameService = new GameService();

    public void playBridgeGame() {
        OutputView.printGameStart();

        Bridge bridge = bridgeService.makeBridge();
        UserBridges userBridges = bridgeService.makeUserBridges();
        gameService.gameStart(bridge, userBridges);
    }
}
