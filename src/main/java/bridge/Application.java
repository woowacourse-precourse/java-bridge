package bridge;

import java.util.List;

public class Application {
    private static final InputView inputView = new InputView();
    private static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        inputView.viewGameStartMessage();
        inputView.checkBridgeValidate();
        List<String> bridge = bridgeMaker.makeBridge(inputView.getSize());
        System.out.println(bridge);
        String input = inputView.readMoving();
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();
        outputView.printMap(input, bridge);
    }
}
