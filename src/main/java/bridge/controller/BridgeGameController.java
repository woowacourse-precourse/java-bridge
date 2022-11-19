package bridge.controller;


import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.service.BridgeGame;
import bridge.service.InputViewService;
import bridge.view.OutputView;

public class BridgeGameController {
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final OutputView outputView = new OutputView();
    private final InputViewService inputViewService = new InputViewService();
    private final BridgeGame bridgeGame = new BridgeGame();

    public void start() {
        printStartGame();
        Bridge bridge = setBridge();
        User user = new User();
        movingBridge(bridge, user);
    }

    public void printStartGame() {
        outputView.printStartGame();
    }
}