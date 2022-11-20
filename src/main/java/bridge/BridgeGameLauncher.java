package bridge;

import java.util.List;

public class BridgeGameLauncher {
    private final InputView inputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;

    public BridgeGameLauncher() {
        this.inputView = new InputView(new Validator());
        this.bridgeGame = new BridgeGame(inputView, new OutputView());
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void game(){
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);

        bridgeGame.setBridge(bridge);
        bridgeGame.startGame();
    }
}
