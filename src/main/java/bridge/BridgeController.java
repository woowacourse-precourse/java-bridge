package bridge;

import domain.Bridge;
import view.InputView;
import view.OutputView;

public class BridgeController {

    private InputView inputView = new InputView();
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;
    private Bridge bridge;

    public BridgeController() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void start() {
        OutputView.printStartMessage();
        int size = inputView.readBridgeSize();
        bridge = new Bridge(bridgeMaker.makeBridge(size));
        System.out.println(bridge.getBridge());
    }

}
