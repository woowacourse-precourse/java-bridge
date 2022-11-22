package bridge;

import bridge.command.BridgeSize;
import bridge.command.Movement;
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
        final Movement movement = askMoving();
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
