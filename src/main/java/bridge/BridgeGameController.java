package bridge;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;

    private final BridgeMaker bridgeMaker;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void init() {
        outputView.printGettingStart();
        int bridgeSize = inputView.readBridgeSize();
        Bridge bridge = Bridge.mapToBridge(bridgeMaker.makeBridge(bridgeSize));
        Player player = new Player();
        bridgeGame = new BridgeGame(bridge, player);
    }
}
