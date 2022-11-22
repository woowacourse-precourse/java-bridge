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
        int size = new BridgeException().bridgeSizeInputException();
        bridge = bridgeMaker.makeBridgeByBridgeRandomNumberGenerator(size);
        blockCount = bridge.size();
        moveController();
    }

    public void moveController() {
        bridgeGame = new BridgeGame();
        moveProcess();
    }

    public void moveProcess() {
        for (int tryCount = 0; tryCount < blockCount; tryCount++) {
            String sideToMove = new InputView().readMoving();
            if (!new BridgeException().moveException(sideToMove)) {
                tryCount -= 1;
                continue;
            }
            tryCount = moveResultProcess(tryCount, sideToMove);
        }
    }

    public int moveResultProcess(int tryCount, String sideToMove) {
        moveResult = bridgeGame.moveResult(bridge, tryCount, sideToMove);
        new OutputView().printMap(moveResult);
        tryCount = gameFailed(tryCount);
        gameEnd(tryCount);
        return tryCount;
    }

    public int gameFailed(int tryCount) {
        if (bridgeGame.isFailed(moveResult)) {
            String retryCommand = new InputView().readGameCommand();
            retryCommand = retryCommandIsROrQ(retryCommand);
            if (retryCommand.equals("R") || retryCommand.equals("Q")) {
                tryCount = failedCase(tryCount, retryCommand);
                return tryCount;
            }
        }
        return tryCount;
    }

    public String retryCommandIsROrQ(String retryCommand) {
        if (!retryCommand.equals("R") && !retryCommand.equals("Q")) {
            retryCommand = new BridgeException().retryException(retryCommand);
            return retryCommand;
        }
        return retryCommand;
    }

    public int failedCase(int tryCount, String retryCommand) {
        if (retryCommand.equals("R")) {
            commandR(retryCommand);
            return -1;
        }
        if (retryCommand.equals("Q")) {
            commandQ(retryCommand);
            return blockCount;
        }
        return tryCount;
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