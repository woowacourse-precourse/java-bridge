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

    private static int tryNumber;
    private static boolean successOrFail = true;
    private static List<String> bridge;
    private static int movingCount = 0;

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
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        ViewMessage.printBridgeSizeInputRequest();

        int bridgeSize = InputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public static void crossBridge() {
        movingCount = 0;
        BridgeMap.reset();
        crossBridgeProcess();
    }

    private static void crossBridgeProcess() {
        while (successOrFail) {
            moveAndCheck();
            movingCount++;

            if (movingCount >= bridge.size()) {
                break;
            }
        }
    }

    private static void moveAndCheck() {
        String moving = getMoving();
        String bridgeBlock = bridge.get(movingCount);

        bridgeGame.move(moving, bridgeBlock);
        OutputView.printMap(BridgeMap.getUpRecord(), BridgeMap.getDownRecord());

        moveWrongBlock(moving, bridgeBlock);
    }

    private static String getMoving() {
        ViewMessage.printMovingInputRequest();

        return InputView.readMoving();
    }

    private static void moveWrongBlock(String moving, String bridgeBlock) {
        if (!moving.equals(bridgeBlock)) {
            ViewMessage.printGameCommandInputRequest();
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
