package bridge;

import bridge.Domain.BridgeGame;
import bridge.View.InputView;
import bridge.View.OutputView;

public class Application {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static BridgeGame initiateBridgeGame() {
        boolean exceptionFlag = true;
        BridgeGame bridgeGame = null;

        inputView.printStartMessage();

        while(exceptionFlag) {
            exceptionFlag = false;

            try {
                int size = inputView.readBridgeSize();
                bridgeGame = new BridgeGame(size);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
                exceptionFlag = true;
            }
        }

        return bridgeGame;
    }

    public static void inputMoving(BridgeGame bridgeGame) {
        boolean exceptionFlag = true;
        while(exceptionFlag) {
            exceptionFlag = false;

            try {
                String selection = inputView.readMoving();
                bridgeGame.move(selection);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
                exceptionFlag = true;
            }
        }
    }

    public static void run(BridgeGame bridgeGame) {
        while(!bridgeGame.winGame() && !bridgeGame.isPlayerDead()) {
            inputMoving(bridgeGame);
            outputView.printMap(bridgeGame);
            bridgeGame.updatePlayer();
        }
    }

    public static void main(String[] args) {
        BridgeGame bridgeGame = initiateBridgeGame();

        run(bridgeGame);
        outputView.printResult(bridgeGame);
    }
}
