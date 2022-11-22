package bridge.controller;


import static bridge.enums.GameCommand.QUIT;
import static bridge.enums.GameCommand.RETRY;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.User;
import bridge.domain.BridgeGame;
import bridge.service.ViewService;
import java.util.List;

public class BridgeGameController {
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final ViewService viewService = new ViewService();

    public void start() {
        printStartGame();
        BridgeGame bridgeGame = new BridgeGame(createBridge());
        User user = new User();
        moveBridge(bridgeGame, user);
    }

    public void printStartGame() {
        viewService.printStartGame();
    }

    public List<String> createBridge() {
        return bridgeMaker.makeBridge(viewService.inputBridgeSize());
    }

    public void moveBridge(BridgeGame bridgeGame, User user) {
        while (!user.isGameOver()) {
            String moveUpOrDown = viewService.inputMoving();
            boolean pass = bridgeGame.isPass(moveUpOrDown);
            viewService.printMap(bridgeGame.getLocation(), pass, moveUpOrDown);
            runPassOrFailCase(pass, bridgeGame, user);
            completeBridge(bridgeGame, user);
        }
        printResult(user);
    }

    public void completeBridge(BridgeGame bridgeGame, User user) {
        if (bridgeGame.isEndOfLocation()) {
            user.finishWithWin();
        }
    }

    public void runPassOrFailCase(boolean pass, BridgeGame bridgeGame, User user) {
        if (pass) {
            bridgeGame.move();
        }
        if (!pass) {
            String gameCommand = viewService.inputGameCommand();
            runFailCase(bridgeGame, user, gameCommand);
        }
    }

    public void runFailCase(BridgeGame bridgeGame, User user, String gameCommand) {
        if (gameCommand.equals(RETRY.getCommand())) {
            viewService.clearMap();
            user.increaseTryCount();
            bridgeGame.retry();
        }
        if (gameCommand.equals(QUIT.getCommand())) {
            user.finishWithFail();
        }
    }

    public void printResult(User user) {
        viewService.printResult(user);
    }
}