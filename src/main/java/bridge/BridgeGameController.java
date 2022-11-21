package bridge;

import util.InputView;
import util.OutputView;

import java.util.List;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = newBridgeGame();
    }

    private BridgeGame newBridgeGame() {
        int bridgeSize = inputView.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return new BridgeGame(bridge);
    }
}
