package bridge;

import bridge.view.InputView;

import java.util.List;

public class GameController {
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private BridgeGame game;

    public GameController() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.inputView = new InputView();
    }

    public void initGame() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridges = bridgeMaker.makeBridge(bridgeSize);
        this.game = new BridgeGame(bridges);
    }

    public void run() {
    }
}
