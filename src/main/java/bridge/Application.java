package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int bridgeSize = inputView.readBridgeSize();
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        String s = inputView.readMoving();
        outputView.printMap(bridge);

        String s1 = inputView.readGameCommand();
        outputView.printResult("실패", 1);
    }
}
