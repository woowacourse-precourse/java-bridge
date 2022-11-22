package bridge;

import static bridge.ui.OutputView.printGameStartMessage;
import static bridge.ui.OutputView.printInputBridgeSizeMessage;

public class Application {

    public static void main(String[] args) {
        printGameStartMessage();
        printInputBridgeSizeMessage();

        try {
            BridgeGame bridgeGame = new BridgeGame();
            bridgeGame.playGame(bridgeGame);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
