package bridge;

public class GameMachine {
    private InputView ui = new InputView();
    private OutputView view = new OutputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    void run() {
        int bridgeSize = ui.readBridgeSize();
        bridgeMaker.makeBridge(bridgeSize);
    }

}
