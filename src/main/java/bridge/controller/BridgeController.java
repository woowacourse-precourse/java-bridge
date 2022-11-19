package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.service.BridgeGame;
import bridge.service.BridgeService;
import bridge.view.OutputView;

public class BridgeController {
    private final BridgeService bridgeService = new BridgeService();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final OutputView outputView = new OutputView();

    public void start() {
        gameStartMessage();
        Bridge bridge = bridgeService.bridgeMaker();
        User user = new User();
        bridgeGame.gameStart(bridge, user);
    }

    public void gameStartMessage() {
        outputView.printGameStart();
    }
}
