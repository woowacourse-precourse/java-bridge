package bridge;

import bridge.Domain.BridgeGame;
import bridge.Domain.Player;
import bridge.View.InputView;
import bridge.View.OutputView;

public class Application {
    public static BridgeGame initiateBridgeGame(InputView inputView) {
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

    public static void inputMoving(InputView inputView, BridgeGame bridgeGame) {
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

        bridgeGame.updatePlayer();
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeGame bridgeGame = initiateBridgeGame(inputView);
        OutputView outputView = new OutputView();

        while(!bridgeGame.winGame() && !bridgeGame.isPlayerDead()) {
            inputMoving(inputView, bridgeGame);
        }
    }
}
