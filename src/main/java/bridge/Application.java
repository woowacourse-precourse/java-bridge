package bridge;

import static bridge.ui.OutputView.printGameStartMessage;
import static bridge.ui.OutputView.printInputBridgeSizeMessage;

public class Application {

    public static void main(String[] args) {
        printGameStartMessage();
        printInputBridgeSizeMessage();

        try {
            BridgeGame bridgeGame = new BridgeGame();
            BridgeGamePlay bridgeGamePlay = new BridgeGamePlay();
            bridgeGamePlay.playGame(bridgeGame);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
