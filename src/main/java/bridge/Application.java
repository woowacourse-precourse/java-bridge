package bridge;

import static bridge.OutputView.printGameStartMessage;
import static bridge.OutputView.printInputBridgeSizeMessage;

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
