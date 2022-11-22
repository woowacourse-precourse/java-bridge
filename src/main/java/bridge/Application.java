package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printGameStart();
        outputView.printInputBridgeSize();

        try {
            int bridgeSize = inputView.readBridgeSize();

            List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
