package bridge;

import bridge.command.BridgeSize;
import bridge.command.Movement;
import bridge.command.Retry;
import bridge.path.Path;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {

    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static void main(String[] args) {
        printTitle();
        final BridgeSize bridgeSize = askBridgeSize();
        final BridgeGame bridgeGame = createBridgeGame(bridgeSize);
        final Path path = run(bridgeGame);
        printResult(bridgeGame, path);
    }

    private static void printResult(
            final BridgeGame bridgeGame,
            final Path path
    ) {
        outputView.printResult(path, bridgeGame.getNumTry());
    }

    private static Path run(final BridgeGame bridgeGame) {
        Path path;
        do {
            final Movement movement = askMoving();
            path = bridgeGame.onMove(movement);
            printMap(path);
            if (path.searchesFailed() && !retries(bridgeGame)) {
                return path;
            }
        } while (!bridgeGame.completes());
        return path;
    }

    private static boolean retries(final BridgeGame bridgeGame) {
        final Retry retry = askRetrying();
        if (retry == Retry.YES) {
            bridgeGame.onRetry();
        }
        return retry.getValue();
    }

    private static Retry askRetrying() {
        outputView.printRetrying();
        return inputView.readRetrying();
    }

    private static void printMap(final Path path) {
        outputView.printMap(path);
    }

    private static Movement askMoving() {
        outputView.printMoving();
        return inputView.readMoving();
    }

    private static BridgeGame createBridgeGame(final BridgeSize bridgeSize) {
        final List<String> rawBridge = bridgeMaker.makeBridge(bridgeSize.getValue());
        final Bridge bridge = Bridge.of(rawBridge);
        return BridgeGame.of(bridge);
    }

    private static BridgeSize askBridgeSize() {
        outputView.printBridgeSize();
        return inputView.readBridgeSize();
    }

    private static void printTitle() {
        outputView.printTitle();
    }
}
