package bridge.controller;

import bridge.*;
import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.domain.BridgeMap;
import bridge.message.Message;
import bridge.view.ViewMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    private static final BridgeGame bridgeGame = new BridgeGame();

    private static int tryNumber = 0;
    private static boolean successOrFail = true;
    private static List<String> bridge;

    public void run() {
        startGame();
        makeBridge();

        crossBridge();

        endGame();
    }

    private void startGame() {
        tryNumber = 1;
        ViewMessage.printGameStartMessage();
    }

    private void makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
    }

    public static void crossBridge() {
        BridgeMap.reset();

        while (successOrFail) {
            moveAndCheck();

            if (BridgeMap.getMovingCount() >= bridge.size()) {
                break;
            }
        }
    }

    private static void moveAndCheck() {
        String moving = InputView.readMoving();;
        String bridgeBlock = bridge.get(BridgeMap.getMovingCount());

        bridgeGame.move(moving, bridgeBlock);
        OutputView.printMap(BridgeMap.getUpRecord(), BridgeMap.getDownRecord());

        moveWrongBlock(moving, bridgeBlock);
    }

    private static void moveWrongBlock(String moving, String bridgeBlock) {
        if (!moving.equals(bridgeBlock)) {
            String gameCommand = InputView.readGameCommand();

            isGameCommandR(gameCommand);
            isGameCommandQ(gameCommand);
        }
    }

    private static void isGameCommandR(String gameCommand) {
        if (gameCommand.equals(Message.RETRY.getMessage())) {
            tryNumber++;
            successOrFail = true;
            bridgeGame.retry();
        }
    }

    private static void isGameCommandQ(String gameCommand) {
        if (gameCommand.equals(Message.QUIT.getMessage())) {
            successOrFail = false;
        }
    }

    public void endGame() {
        if (successOrFail) {
            printGameResult();
        }
        if (!successOrFail) {
            printGameResult();
        }
    }

    private void printGameResult() {
        ViewMessage.printEndGameMessage();
        OutputView.printMap(BridgeMap.getUpRecord(), BridgeMap.getDownRecord());
        OutputView.printResult(tryNumber, successOrFail);
    }
}
