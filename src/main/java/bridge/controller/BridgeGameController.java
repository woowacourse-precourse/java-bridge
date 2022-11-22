package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.model.Bridge;
import bridge.model.BridgeMap;
import bridge.model.Player;

import static bridge.util.BridgeConstant.QUIT_GAME;
import static bridge.view.InputView.readBridgeSize;
import static bridge.view.InputView.readMoving;
import static bridge.view.InputView.readGameCommand;
import static bridge.view.OutputView.printMap;
import static bridge.view.OutputView.printResult;
import static bridge.view.OutputView.printStartMessage;

public class BridgeGameController {
    private static final boolean WIN = true;
    private static final boolean LOSE = false;

    private boolean isContinue = true;
    private boolean isWin = false;
    BridgeGame bridgeGame = new BridgeGame();
    Bridge bridge;

    public void init() {
        printStartMessage();
        BridgeMap.getBridgeMap().initializeBridges();
        bridge = getNewBridge();
        start(new Player());
    }

    private void start(Player player) {
        while (isContinue) {
            movePlayer(player);
            checkPlayerMove(player);
            judgeBridgeGame(player);
        }
        printResult(isWin, player.getTryCount());
    }

    private void judgeBridgeGame(Player player) {
        if (bridgeGame.judge(player, bridge)) {
            gameSet(WIN);
        }
    }

    private Bridge getNewBridge() {
        int bridgeSize = readBridgeSize();
        return new Bridge(bridgeSize);
    }

    private void checkPlayerMove(Player player) {
        boolean moveSuccess = bridgeGame.check(player, bridge);
        printMap();
        if (!moveSuccess) {
            selectContinueOrQuit(player);
        }
    }

    private void movePlayer(Player player) {
        String moveTo = readMoving();
        bridgeGame.move(player, moveTo);
    }

    private void selectContinueOrQuit(Player player) {
        String continueCode = readGameCommand();
        if (!bridgeGame.retry(player, continueCode)) {
            gameSet(LOSE);
        }
    }

    private void gameSet(boolean winOrLose) {
        isWin = winOrLose;
        isContinue = QUIT_GAME;
    }
}
