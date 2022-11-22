package bridge;

import view.InputView;
import view.OutputView;

import java.util.List;

public class BridgeController {
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private List<String> moveResult;
    private List<String> bridge;
    private int blockCount;
    private int gameCount = 1;
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public void run() {
        new OutputView().printStart();
        makeBridgeController();
    }

    public void makeBridgeController() {
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        int size = new InputView().readBridgeSize();
        bridge = bridgeMaker.makeBridgeByBridgeRandomNumberGenerator(size);
        blockCount = bridge.size();
        moveController();
    }

    public void moveController() {
        bridgeGame = new BridgeGame();
        for (int i = 0; i < blockCount; i++) {
            String sideToMove = new InputView().readMoving();
            moveResult = bridgeGame.moveResult(bridge, i, sideToMove);
            new OutputView().printMap(moveResult);
            i = gameFailed(i);
            gameEnd(i);
        }
    }

    public int gameFailed(int i) {
        if (bridgeGame.isFailed(moveResult)) {
            String retryCommand = new InputView().readGameCommand();
            i = failedCase(i, retryCommand);
            return i;
        }
        return i;
    }

    public int failedCase(int i, String retryCommand) {
        if (retryCommand.equals("R")) {
            commandR(retryCommand);
            return -1;
        }
        if (retryCommand.equals("Q")) {
            commandQ(retryCommand);
            return blockCount;
        }
        return i;
    }

    public void commandR(String retryCommand) {
        gameCount++;
        retryController(retryCommand, gameCount);
    }

    public void commandQ(String retryCommand) {
        retryController(retryCommand, gameCount);
    }

    public void gameEnd(int i) {
        if (i == blockCount - 1) {
            new OutputView().printSuccessResult(moveResult, gameCount);
        }
    }

    public void retryController(String retryCommand, int gameCount) {
        bridgeGame = new BridgeGame();
        bridgeGame.retry(retryCommand, moveResult, gameCount);
    }

    public void resultController(List<String> moveResult, int gameCount) {
        new OutputView().printFailedResult(moveResult, gameCount);
    }
}