package bridge.bridgeGame;

import bridge.bridge.BridgeNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameRunner {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame;

    public BridgeGameRunner(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeGame = new BridgeGame(bridgeNumberGenerator);
    }

    private void initGame() {
        outputView.printInitGameMessage();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.makeBridge(bridgeSize);
    }
}
