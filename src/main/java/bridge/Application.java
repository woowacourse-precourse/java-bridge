package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            OutputView outputView = new OutputView();
            InputView inputView = new InputView();
            BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

            outputView.printGameStartMessage();
            int bridgeSize = inputView.readBridgeSize();
            System.out.println("bridgeSize = " + bridgeSize);

            List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
            System.out.println("bridge = " + bridge);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
