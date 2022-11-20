package bridge;

import static bridge.io.InputView.readBridgeSize;
import static bridge.io.OutputView.printGetBridgeSize;
import static bridge.io.OutputView.printStartMessage;

public class Application {

    private static BridgeGame bridgeGame;

    public static void main(final String[] args) {
        bridgeGame = createBridgeGame();
        do {
            setupBridge();

        } while (bridgeGame.retry());
    }

    private static BridgeGame createBridgeGame() {
        printStartMessage();
        final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return new BridgeGame(bridgeMaker);
    }

    private static void setupBridge() {
        printGetBridgeSize();
        final int bridgeSize = readBridgeSize();
        bridgeGame.setBridge(bridgeSize);
    }
}
