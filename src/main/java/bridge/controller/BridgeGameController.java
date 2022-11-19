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

    public Bridge setBridge() {
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(inputViewService.inputBridgeSize()));
        return bridge;
    }

    public void movingBridge(Bridge bridge, User user) {
        while (!user.isGameOver()) {
            String moveUpOrDown = inputViewService.inputMoving();
            boolean pass = bridge.isPass(moveUpOrDown);
            outputView.printMap(bridge.getLocation(), pass, moveUpOrDown);
            passOrFail(pass, bridge, user);
        }
        printResult(user);
    }

    public void passOrFail(boolean pass, Bridge bridge, User user) {
        if (pass) {
            bridgeGame.move(bridge, user);
        }
        if (!pass) {
            fail(bridge, user);
        }
    }

    public void fail(Bridge bridge, User user) {
        String gameCommand = inputViewService.inputGameCommand();
        if (gameCommand.equals("R")) {
            outputView.initUpOrDownState();
            bridgeGame.retry(bridge, user);
        }
        if (gameCommand.equals("Q")) {
            user.setGameOver();
        }
    }
}