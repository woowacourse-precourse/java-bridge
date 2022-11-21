package bridge;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    private static final InputView inputView;
    private static final OutputView outputView;
    private static BridgeGame bridgeGame;

    static {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public static void main(String[] args) throws IllegalArgumentException {
        try {
            initializeGame();
            playUntilEnd();
            gameOver();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void initializeGame() {
        outputView.printWelcome();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
    }

    private static void playUntilEnd() {
        boolean moved;

        while (!bridgeGame.isEnd()) {
            moved = moveToNext();
            showMap();
            checkSuccess(moved);
        }
    }

    private static boolean moveToNext() {
        String direction = inputView.readMoving();
        return bridgeGame.move(direction);
    }

    private static void showMap() {
        outputView.printMap(bridgeGame.getMap());
    }

    private static void checkSuccess(boolean moved) {
        if (!moved) {
            String gameCommand = inputView.readGameCommand();
            bridgeGame.retry(gameCommand);
        }
    }

    private static void gameOver() {
        outputView.printResult(
                bridgeGame.getMap(),
                bridgeGame.isSuccess(),
                bridgeGame.getTryCount()
        );
    }
}
