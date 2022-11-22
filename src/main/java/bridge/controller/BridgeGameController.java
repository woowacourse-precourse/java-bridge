package bridge.controller;


import static bridge.enums.GameCommand.QUIT;
import static bridge.enums.GameCommand.RETRY;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.User;
import bridge.domain.BridgeGame;
import bridge.util.BridgeMapUpdater;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeMapUpdater bridgeMapUpdater = new BridgeMapUpdater();

    public void start() {
        printStartGame();
        BridgeGame bridgeGame = new BridgeGame(createBridge());
        User user = new User();
        moveBridge(bridgeGame, user);
    }

    private void printStartGame() {
        outputView.printStartGame();
    }

    private int choiceBridgeSize() {
        outputView.printChoiceBridgeSize();
        return inputView.readBridgeSize();
    }

    private List<String> createBridge() {
        return bridgeMaker.makeBridge(choiceBridgeSize());
    }

    private void moveBridge(BridgeGame bridgeGame, User user) {
        while (!user.isGameOver()) {
            String moveUpOrDown = choiceMove();
            boolean pass = bridgeGame.isPass(moveUpOrDown);
            printMap(bridgeGame.getLocation(), pass, moveUpOrDown);
            checkPassOrFailCase(pass, bridgeGame, user);
            isArriveByEnd(bridgeGame, user);
        }
        printResult(user);
    }

    private String choiceMove() {
        outputView.printChoiceUpOrDown();
        return inputView.readMoving();
    }

    private void printMap(int location, boolean pass, String moveUpOrDow) {
        bridgeMapUpdater.setMap(location, pass, moveUpOrDow);
        outputView.printMap(bridgeMapUpdater.getUpdatedBridgeMap());
    }

    private void isArriveByEnd(BridgeGame bridgeGame, User user) {
        if (bridgeGame.isEndOfLocation()) {
            user.finishWithWin();
        }
    }

    private void checkPassOrFailCase(boolean pass, BridgeGame bridgeGame, User user) {
        if (pass) {
            runPassCase(bridgeGame);
        }
        if (!pass) {
            String gameCommand = choiceMoveGameCommand();
            runFailCase(bridgeGame, user, gameCommand);
        }
    }

    private String choiceMoveGameCommand() {
        outputView.printChoiceRetry();
        return inputView.readGameCommand();
    }

    private void runPassCase(BridgeGame bridgeGame) {
        bridgeGame.move();
    }

    private void runFailCase(BridgeGame bridgeGame, User user, String gameCommand) {
        if (gameCommand.equals(RETRY.getCommand())) {
            retry(bridgeGame, user);
        }
        if (gameCommand.equals(QUIT.getCommand())) {
            giveUp(user);
        }
    }

    private void retry(BridgeGame bridgeGame, User user) {
        bridgeMapUpdater.clearMap();
        user.increaseTryCount();
        bridgeGame.retry();
    }

    private void giveUp(User user) {
        user.finishWithFail();
    }

    private void printResult(User user) {
        outputView.printResult(user, bridgeMapUpdater.getUpdatedBridgeMap());
    }
}