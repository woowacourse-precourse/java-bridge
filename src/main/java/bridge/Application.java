package bridge;

import bridge.BridgeMaker.BridgeMaker;
import bridge.BridgeMaker.NumberGenerator.BridgeRandomNumberGenerator;
import bridge.UI.Input.InputView;
import bridge.UI.Output.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        OutputView outputView = new OutputView(bridge);

        String move = inputView.readMoving();
        outputView.printMap(0, move);
        inputView.readGameCommand();
    }
}
