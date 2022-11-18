package bridge;

import java.util.List;

public class GameManager {
    InputView inputView;
    OutputView ouputView;


    public GameManager(InputView input, OutputView output) {
        this.inputView = input;
        this.ouputView = output;
    }

    public void start() {
        ouputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
    }
}
