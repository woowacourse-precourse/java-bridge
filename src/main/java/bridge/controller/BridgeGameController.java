package bridge.controller;


import static bridge.enums.GameCommand.QUIT;
import static bridge.enums.GameCommand.RETRY;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.User;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        printStartGame();
        BridgeGame bridgeGame = new BridgeGame(createBridge());
        User user = new User();
        moveBridge(bridgeGame, user);
    }

    public void printStartGame() {
        outputView.printStartGame();
    }

    public List<String> createBridge() {
        outputView.printChoiceBridgeSize();
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    public void moveBridge(BridgeGame bridgeGame, User user) {
        while (!user.isGameOver()) {
            outputView.printChoiceUpOrDown();
            String moveUpOrDown = inputView.readMoving();
            boolean pass = bridgeGame.isPass(moveUpOrDown);
            outputView.printMap(bridgeGame.getLocation(), pass, moveUpOrDown);
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
            outputView.printChoiceRetry();
            String gameCommand = inputView.readGameCommand();
            runFailCase(bridgeGame, user, gameCommand);
        }
    }

    public void runFailCase(BridgeGame bridgeGame, User user, String gameCommand) {
        if (gameCommand.equals(RETRY.getCommand())) {
            outputView.clearMap();
            user.increaseTryCount();
            bridgeGame.retry();
        }
        if (gameCommand.equals(QUIT.getCommand())) {
            user.finishWithFail();
        }
    }

    public void printResult(User user) {
        outputView.printResult(user);
    }
}