package bridge.controller;


import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.service.BridgeGame;
import bridge.service.ViewService;
import java.util.List;

public class BridgeGameController {
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final ViewService viewService = new ViewService();
    private final BridgeGame bridgeGame = new BridgeGame();

    public void start() {
        printStartGame();
        Bridge bridge = new Bridge(createBridge());
        User user = new User();
        moveBridge(bridge, user);
    }

    public void printStartGame() {
        viewService.printStartGame();
    }

    public List<String> createBridge() {
        return bridgeMaker.makeBridge(viewService.inputBridgeSize());
    }

    public void moveBridge(Bridge bridge, User user) {
        while (!user.isGameOver()) {
            String moveUpOrDown = viewService.inputMoving();
            boolean pass = bridge.isPass(moveUpOrDown);
            viewService.printMap(bridge.getLocation(), pass, moveUpOrDown);
            runPassOrFailCase(pass, bridge, user);
        }
        printResult(user);
    }

    public void runPassOrFailCase(boolean pass, Bridge bridge, User user) {
        if (pass) {
            bridgeGame.move(bridge, user);
        }
        if (!pass) {
            String gameCommand = viewService.inputGameCommand();
            runFailCase(bridge, user, gameCommand);
        }
    }

    public void runFailCase(Bridge bridge, User user, String gameCommand) {
        if (gameCommand.equals(RETRY)) {
            viewService.clearMap();
            bridgeGame.retry(bridge, user);
        }
        if (gameCommand.equals(QUIT)) {
            user.finishWithFail();
        }
    }

    public void printResult(User user) {
        viewService.printResult(user);
    }
}