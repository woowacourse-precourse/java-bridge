package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new BridgeValidator());
        OutputView outputView = new OutputView();

        outputView.printGameStart();
        BridgeGame bridgeGame = initBridgeGame(inputView, outputView);
        bridgeGame.start();
    }

    private static BridgeGame initBridgeGame(InputView inputView, OutputView outputView) {
        return new BridgeGame(makeBridge(inputView, outputView), inputView);
    }

    private static List<String> makeBridge(InputView inputView, OutputView outputView) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        outputView.printGuideForBridgeSize();
        int bridgeSize = inputView.readBridgeSize();

        return bridgeMaker.makeBridge(bridgeSize);
    }
}
