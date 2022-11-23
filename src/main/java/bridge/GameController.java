package bridge;

import java.util.List;

public class GameController {

    private final BridgeGame bridgeGame;
    private final OutputView outputView;
    private final InputView inputView;

    public GameController(final BridgeGame bridgeGame, final OutputView outputView, final InputView inputView) {
        this.bridgeGame = bridgeGame;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void play() {
        List<String> bridge = createBridge();
        bridgeGame.playGame(bridge);
    }

    private List<String> createBridge() {
        outputView.printGameStartMessage();
        int bridgeSize = inputView.readBridgeSize();
        return new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
    }
}
