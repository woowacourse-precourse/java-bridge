package bridge;

import java.util.List;

import static bridge.InputView.readBridgeSize;
import static bridge.OutputView.printGameStartMessage;
import static bridge.OutputView.printInputBridgeSizeMessage;

public class Application {

    public static void main(String[] args) {

        printGameStartMessage();
        printInputBridgeSizeMessage();

        try {
            int bridgeSize = readBridgeSize();
            int count = 1;

            List<String> randomBridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
            System.out.println(randomBridge);

            BridgeGame bridgeGame = new BridgeGame();
            if (!bridgeGame.initGame(bridgeSize, bridgeGame, randomBridge)) {
                while (!bridgeGame.retry(bridgeSize, randomBridge)) {
                    count += 1;
                }
            }
            System.out.println(count);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
