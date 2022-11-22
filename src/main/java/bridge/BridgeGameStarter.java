package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeGameStarter {

    private final Map<String, Boolean> gameStatusFlag = new HashMap<>();
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private List<String> bridge = new ArrayList<>();
    private List<String> movingLog = new ArrayList<>();
    private int tryCount = 1;

    public BridgeGameStarter(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    private void initialize() {
        outputView.printGameStartContext();
        outputView.printInputBridgeSize();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        outputView.printInputMoving();
        movingLog = bridgeGame.move(inputView.readMoving(), bridge, 0);
        outputView.printMap(movingLog);
    }

    private void reInitialize() {
        tryCount++;
        outputView.printInputBridgeSize();
        outputView.printInputMoving();
        bridgeGame.initializeLeftRightMovingLog();
        movingLog = bridgeGame.move(inputView.readMoving(), bridge, 0);
        outputView.printMap(movingLog);
    }

    private int additionalInput(int index) {
        outputView.printInputMoving();
        movingLog = bridgeGame.move(inputView.readMoving(), bridge, index);
        outputView.printMap(movingLog);
        index++;
        return index;
    }

    private void notifySuccessGame() {
        gameStatusFlag.put("successFlag", true);
        gameStatusFlag.put("retryFlag", false);
    }

    private void notifyFailGameWithRetry() {
        gameStatusFlag.put("successFlag", false);
        gameStatusFlag.put("retryFlag", true);
    }

    private void notifyFailGameWithNotRetry() {
        gameStatusFlag.put("successFlag", false);
        gameStatusFlag.put("retryFlag", false);
    }

    private boolean proceed() {
        int index = 1;
        while (bridgeGame.canMove(movingLog)) {
            if (bridgeGame.isGameEnded(bridge, index)) {
                notifySuccessGame();
                return true;
            }
            index = additionalInput(index);
        }
        return false;
    }

    private void askToRetry() {
        outputView.printInputGameCommand();
        if (bridgeGame.retry(inputView.readGameCommand())) {
            notifyFailGameWithRetry();
            return;
        }
        notifyFailGameWithNotRetry();
    }

    private void closeGame() {
        outputView.printFinalMap(movingLog);
        outputView.printResult(gameStatusFlag.get("successFlag"), tryCount);
    }

    public void run() {
        initialize();
        if (proceed()) {
            closeGame();
            return;
        }
        askToRetry();
        while (gameStatusFlag.get("retryFlag")) {
            reInitialize();
            if (proceed()) break;
            askToRetry();
        }
        closeGame();
    }
}
