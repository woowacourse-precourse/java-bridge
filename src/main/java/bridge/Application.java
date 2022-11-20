package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printGreeting();

        outputView.printBridgeSizeInputMessage();
        int bridgeSize = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        BridgeGame bridgeGame = new BridgeGame(bridge);

        outputView.printMoveInputMessage();
    }
}
