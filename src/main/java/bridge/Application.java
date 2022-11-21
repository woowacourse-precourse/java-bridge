package bridge;

import bridge.Domain.BridgeGame;
import bridge.View.InputView;
import bridge.View.OutputView;



public class Application {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();


    public static BridgeGame initiateBridgeGame() {
        while (true) {
            try {
                int size = inputView.readBridgeSize();

                return new BridgeGame(size);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

    public static void inputMoving(BridgeGame bridgeGame) {
        while (true) {
            try {
                String selection = inputView.readMoving();
                bridgeGame.move(selection);

                return;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

    public static void inputCommand(BridgeGame bridgeGame) {
        while (true) {
            try {
                String command = inputView.readGameCommand();
                bridgeGame.retry(command);

                return;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

    public static void run(BridgeGame bridgeGame) {
        while (!bridgeGame.isGameOver()) {
            inputMoving(bridgeGame);
            outputView.printMap(bridgeGame, bridgeGame.getPassedCount());
            bridgeGame.updatePlayer();

            if (bridgeGame.isPlayerDead()) {
                inputCommand(bridgeGame);
            }
        }
    }

    public static void main(String[] args) {
        inputView.printStartMessage();

        BridgeGame bridgeGame = initiateBridgeGame();

        run(bridgeGame);

        outputView.printResult(bridgeGame);
    }
}
