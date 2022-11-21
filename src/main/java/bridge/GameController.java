package bridge;

import java.util.ArrayList;
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

        while(successOrFail) {
            ViewMessage.printMovingInputRequest();

            String moving = InputView.readMoving();
            String bridgeBlock = bridge.get(movingCount);

            bridgeGame.move(moving, bridgeBlock);
            OutputView.printMap(BridgeMap.getUpRecord(), BridgeMap.getDownRecord());

            if(!moving.equals(bridgeBlock)) {
                ViewMessage.printGameCommandInputRequest();
                String gameCommand = InputView.readGameCommand();

                if(gameCommand.equals("R")) {
                    tryNumber++;
                    successOrFail = true;
                    bridgeGame.retry();
                }
                if(gameCommand.equals("Q")) {
                    successOrFail = false;
                }
            }

            movingCount++;

            if(movingCount >= bridge.size()) {
                break;
            }
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
