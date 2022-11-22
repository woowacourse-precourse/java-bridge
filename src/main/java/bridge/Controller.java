package bridge;

import static bridge.ValidateBridge.validateBridgeSize;

public class Controller {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;
    private BridgeNumberGenerator bridgeNumberGenerator;

    public Controller() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    }

    public void run() {
        String beforeValidateSize = inputView.readBridgeSize();
        int size = validateBridgeSize(beforeValidateSize);
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeMaker.makeBridge(size);
    }
}
