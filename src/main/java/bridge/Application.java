package bridge;

import java.util.List;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printStart();
        outputView.printEnterBridgeSize();
        try {
            int bridgeSize = inputView.readBridgeSize();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }
}
