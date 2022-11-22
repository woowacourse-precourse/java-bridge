package bridge;

import static bridge.ValidateBridge.validateBridgeSize;
import static bridge.ValidateBridge.validateMovement;

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
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    }

    public void run() {
        String beforeValidateSize = inputView.readBridgeSize();
        int size = validateBridgeSize(beforeValidateSize);
        bridgeMaker.makeBridge(size);
        String BeforeMovement = inputView.readMoving();
        String movement = validateMovement(BeforeMovement);
    }
}
