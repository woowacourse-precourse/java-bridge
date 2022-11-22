package bridge;

import bridge.constant.Direction;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = null;
        outputView.printGreeting();

        while (bridgeGame == null) {
            bridgeGame = initializeGame(inputView);
        }

        loopGame(bridgeGame, inputView);
    }

    private static BridgeGame initializeGame(InputView inputView) {
        try {
            int bridgeSize = inputView.readBridgeSize();
            BridgeGame bridgeGame = new BridgeGame(bridgeSize);
            return bridgeGame;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static void loopGame(BridgeGame bridgeGame, InputView inputView) {
        int tryCount = 0;

        while (tryCount != -1) {
            Direction direction = null;

            while (direction == null) {
                direction = readMoving(inputView);
            }
            tryCount = processGameStatus(bridgeGame, bridgeGame.move(direction), tryCount);
        }
    }

    private static Direction readMoving(InputView inputView) {
        try {
            Direction direction = inputView.readMoving();
            return direction;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static int processGameStatus(BridgeGame bridgeGame, BridgeGameStatus bridgeGameStatus, int tryCount) {
        OutputView outputView = new OutputView();
        outputView.printMap(bridgeGameStatus);

        tryCount = processInvalidBridge(bridgeGame, bridgeGameStatus, tryCount);
        tryCount = processArrival(bridgeGameStatus, outputView, tryCount);
        return tryCount;
    }

    private static int processInvalidBridge(BridgeGame bridgeGame, BridgeGameStatus bridgeGameStatus, int tryCount) {
        InputView inputView = new InputView();

        if (!BridgeGameStatus.isValid(bridgeGameStatus) && !loopReadGameCommand(inputView)) {
            return quitGame(bridgeGameStatus, tryCount);
        }

        if (!BridgeGameStatus.isValid(bridgeGameStatus)) {
            return retryGame(bridgeGame, tryCount);
        }
        return tryCount;
    }

    private static boolean loopReadGameCommand(InputView inputView) {
        Boolean isGameContinue = null;

        while (isGameContinue == null) {
            isGameContinue = ReadGameCommand(inputView);
        }

        return isGameContinue;
    }

    private static Boolean ReadGameCommand(InputView inputView) {
        try {
            boolean isGameContinue = inputView.readGameCommand();
            return isGameContinue;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static int quitGame(BridgeGameStatus bridgeGameStatus, int tryCount) {
        OutputView outputView = new OutputView();
        tryCount++;
        outputView.printResult(bridgeGameStatus, tryCount);
        return -1;
    }

    private static int retryGame(BridgeGame bridgeGame, int tryCount) {
        bridgeGame.retry();
        return ++tryCount;
    }

    private static int processArrival(BridgeGameStatus bridgeGameStatus, OutputView outputView, int tryCount) {
        if (BridgeGameStatus.isArrived(bridgeGameStatus)) {
            tryCount++;
            outputView.printResult(bridgeGameStatus, tryCount);
            return -1;
        }

        return tryCount;
    }
}