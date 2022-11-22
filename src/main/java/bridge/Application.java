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

        return tryCount;
    }
}